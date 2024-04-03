package com.rungroup.web10.controllers;

import com.rungroup.web10.dto.ProductDto;
import com.rungroup.web10.models.Product;
import com.rungroup.web10.services.ProductService;
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

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String listProducts(Model model){
        List<ProductDto> products = productService.findAllProducts();
        model.addAttribute("products", products);
        return "products-list";
    }

    @GetMapping("/products/{productId}")
    public String productDetail(@PathVariable("productId") long productId, Model model){
           ProductDto productDto = productService.findProductById(productId);
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
        ProductDto product = productService.findProductById(productId);
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

}
