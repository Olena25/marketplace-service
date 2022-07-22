package com.intellias.marketplaceservice.controller;

import com.intellias.marketplaceservice.dto.BuyProductDto;
import com.intellias.marketplaceservice.dto.UserDto;
import com.intellias.marketplaceservice.exception.UserNotFoundException;
import com.intellias.marketplaceservice.exception.UserValidationException;
import com.intellias.marketplaceservice.model.Product;
import com.intellias.marketplaceservice.model.User;
import com.intellias.marketplaceservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return "main-page";
    }

    @PostMapping(value = "/users", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String addNewUser(@ModelAttribute UserDto userDto, Model model) {
        try {
            userService.add(userDto);
        } catch (UserValidationException e) {
            model.addAttribute("message", e.getMessage());

            return "add-user";
        }

        model.addAttribute("message", "Successfully added");

        return "add-user";
    }
     @PostMapping(value = "/users/products",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String buyProductForUser(@ModelAttribute BuyProductDto buyProductDto, Model model){
        try {
            userService.buyProductForUser(buyProductDto);
        }catch (RuntimeException e){
            model.addAttribute("message",e.getMessage());

            return "buy-product";
        }

        model.addAttribute("message", "Successfully purchased");

        return "buy-product";
     }
      @GetMapping("/users/products")
     public String showUserProducts(@RequestParam String userId, Model model){
        try {
           User user = userService.findById(userId);
           model.addAttribute("products", user.getProducts());

        } catch (UserNotFoundException e) {
            model.addAttribute("message", e.getMessage());
        }

        return "user-products";
     }


}
