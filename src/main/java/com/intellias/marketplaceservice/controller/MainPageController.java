package com.intellias.marketplaceservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class MainPageController {

    @GetMapping("/")
    public String showMainPage(){
        log.info("Showing main page");

        return "main-page";
    }

    @GetMapping("/add-user")
    public String showAddUserPage(){
        log.info("Showing add user page");

        return "add-user";
    }

    @GetMapping("/add-product")
    public String showAddProductPage(){
        log.info("Showing add product page");

        return "add-product";
    }

}
