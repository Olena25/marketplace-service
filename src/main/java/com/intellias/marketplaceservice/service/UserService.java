package com.intellias.marketplaceservice.service;

import com.intellias.marketplaceservice.db.ProductDatabase;
import com.intellias.marketplaceservice.db.UserDatabase;
import com.intellias.marketplaceservice.dto.BuyProductDto;
import com.intellias.marketplaceservice.dto.UserDto;
import com.intellias.marketplaceservice.exception.NotEnoughMoneyException;
import com.intellias.marketplaceservice.exception.ProductNotFoundException;
import com.intellias.marketplaceservice.exception.UserNotFoundException;
import com.intellias.marketplaceservice.exception.UserValidationException;
import com.intellias.marketplaceservice.model.Product;
import com.intellias.marketplaceservice.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserDatabase userDatabase;
    private ProductDatabase productDatabase;

    public List<User> findAll() {
        log.info("Searching for all users");
        return userDatabase.findAll();
    }

    public void add(UserDto userDto) {
        log.info("Adding user");
        if (userDto.getFirstName().isEmpty() || userDto.getLastName().isEmpty()) {
            log.error("First name or last name empty");

            throw new UserValidationException("First name or last name is empty");
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAmountOfMoney(userDto.getAmountOfMoney());
        user.setProducts(new ArrayList<>());
        user.setId(UUID.randomUUID());

        userDatabase.save(user);
    }

    public User findById(String userId) {
        User user = userDatabase.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User with id " + userId + " not found");
        }

        return user;
    }

    public void buyProductForUser(BuyProductDto buyProductDto) {
        String userId = buyProductDto.getUserId();
        String productId = buyProductDto.getProductId();

        log.info("Buy product for userId {} and productId {}", userId, productId);

        User user = findById(userId);

        Product product = productDatabase.findProductById(productId);

        if (product == null) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        if (user.getAmountOfMoney() < product.getPrice()) {
            throw new NotEnoughMoneyException("User with id " + userId + " does not have enough money to buy product");
        }

        user.getProducts().add(product);
        long newAmountOfMoney = user.getAmountOfMoney() - product.getPrice();
        user.setAmountOfMoney(newAmountOfMoney);
    }
}
