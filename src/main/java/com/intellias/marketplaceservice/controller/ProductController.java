package com.intellias.marketplaceservice.controller;

import com.intellias.marketplaceservice.service.ProductService;
import com.intellias.marketplaceservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
