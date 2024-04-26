package com.rungroup.web10.controllers;

import com.rungroup.web10.controllers.Recaptcha.ReCaptchaResponce;
import com.rungroup.web10.dto.RegistrationDto;
import com.rungroup.web10.models.UserEntity;
import com.rungroup.web10.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


@Controller
public class AuthController {
    private UserService userService;
    private final RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String recaptchaSecret;

    @Value("${recaptcha.url}")
    private String recaptchaUrl;


    public AuthController(UserService userService,RestTemplate restTemplate ) {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(Model model){
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String register(@Valid @ModelAttribute("user")RegistrationDto user,
                           BindingResult result, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");

        if (!verifyRecaptcha(gRecaptchaResponse)){
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }

        UserEntity existingUserEmail = userService.findByEmail(user.getEmail());
        if (existingUserEmail != null && existingUserEmail.getEmail() != null && !existingUserEmail.getEmail().isEmpty()){
           return "redirect:/register?fail";
        }
        UserEntity existingUserUsername = userService.findByUsername(user.getUsername());
        if (existingUserUsername != null && existingUserUsername.getUserName() != null && !existingUserUsername.getUserName().isEmpty()){
            return "redirect:/register?fail";
        }
        if (result.hasErrors()){
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/products?success";
    }

    private boolean verifyRecaptcha(String gRecaptchaResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("secret", recaptchaSecret);
        map.add("response", gRecaptchaResponse);
        HttpEntity<MultiValueMap<String, String >> request = new HttpEntity<>(map, headers);
        ReCaptchaResponce response =  restTemplate.postForObject(recaptchaUrl,request, ReCaptchaResponce.class );

        System.out.println("Success " + response.isSuccess());
        System.out.println("Hostname " + response.getHostname());
        System.out.println("Challenge Timestamp " + response.getChallenge_ts());

        return response.isSuccess();
    }
}

@Configuration
class AppConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}



