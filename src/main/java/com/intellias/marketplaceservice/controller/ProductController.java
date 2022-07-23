package com.intellias.marketplaceservice.controller;

import com.intellias.marketplaceservice.dto.ProductDto;
import com.intellias.marketplaceservice.exception.ProductNotFoundException;
import com.intellias.marketplaceservice.model.User;
import com.intellias.marketplaceservice.service.ProductService;
import com.intellias.marketplaceservice.model.Product;
import com.intellias.marketplaceservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String findAllProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "main-page";
    }

    @PostMapping(value = "/products", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String addProduct(@ModelAttribute ProductDto productDto, Model model) {
        try {
            productService.add(productDto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());

            return "add-product";
        }
        model.addAttribute("message", "Product successfully added");
        return "add-product";
    }

    @GetMapping("/products/users")
    public String findUsersByProduct(@RequestParam String productId, Model model) {
        try {
            Product product = productService.findById(productId);
            List<User> users = userService.findUsersByProduct(product);
            model.addAttribute("product", product);
            model.addAttribute("users", users);
        } catch (ProductNotFoundException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "user-by-product";
    }

    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam String productId, Model model) {
        try {
            userService.deleteProductFromUser(productId);
            productService.deleteProduct(productId);
            model.addAttribute("productDeleteMessage", "Successfully deleted");
        } catch (ProductNotFoundException e) {
            model.addAttribute("productDeleteMessage", e.getMessage());

        }
        return "main-page";
    }

}
