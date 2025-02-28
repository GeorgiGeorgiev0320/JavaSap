package com.rungroup.web10.controllers;

import com.rungroup.web10.dto.ProductDto;
import com.rungroup.web10.models.Product;
import com.rungroup.web10.models.UserEntity;
import com.rungroup.web10.security.SecurityUtil;
import com.rungroup.web10.services.ProductService;
import com.rungroup.web10.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductController {
    private ProductService productService;
    private UserService userService;

    @Autowired
    public ProductController(ProductService productService, UserService userService) {

        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        UserEntity user = new UserEntity();
        List<ProductDto> products = productService.findAllProducts();
        String username = SecurityUtil.getSessionUSer();
        if (username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("products", products);
        return "products-list";
    }

    @GetMapping("/products/{productId}")
    public String productDetail(@PathVariable("productId") long productId, Model model){
           UserEntity user = new UserEntity();
           ProductDto productDto = productService.findProductById(productId);
           String username = SecurityUtil.getSessionUSer();
           if (username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
           }
           model.addAttribute("user", user);
           model.addAttribute("product", productDto);
           return "products-detail";
    }

    @GetMapping("/add")
    public String createProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "products-add";
    }

    @PostMapping("/add")
    public String saveProduct(@Valid @ModelAttribute("product")ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            return "products-add";
        }
        productService.saveProduct(productDto);
        return "redirect:/products";
    }

    @GetMapping("/{productId}/edit")
    public String editProducts(@PathVariable("productId") long productId, Model model){
        UserEntity user = new UserEntity();
        ProductDto product = productService.findProductById(productId);
        String username = SecurityUtil.getSessionUSer();

        if (username != null){
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        if (product.getCreatedBy() != user){
            return "redirect:/products";
        }
        model.addAttribute("user", user);
        model.addAttribute("product",product);
        return "products-edit";
    }

    @PostMapping("/{productId}/edit")
    public String saveEditedProducts(@PathVariable("productId") long productId,
                                     @Valid
                                     @ModelAttribute("product") ProductDto product,
                                     BindingResult result){
        if (result.hasErrors()){
            return "products-edit";
        }
        productService.updateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/about")
    public String aboutPage(){
        return "about";
    }

}


