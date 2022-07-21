package com.intellias.marketplaceservice.controller;

import com.intellias.marketplaceservice.dto.ProductDto;
import com.intellias.marketplaceservice.service.ProductService;
import com.intellias.marketplaceservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String findAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "main-page";
    }

    @PostMapping(value = "/products",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addProduct(@ModelAttribute ProductDto productDto, Model model){
        try {
            productService.add(productDto);
        }catch (IllegalArgumentException e){
            model.addAttribute("message",e.getMessage());

            return "add-product";
        }
        model.addAttribute("message","Product successfully added");
        return "add-product";
    }

}
