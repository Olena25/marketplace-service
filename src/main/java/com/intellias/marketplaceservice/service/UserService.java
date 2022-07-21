package com.intellias.marketplaceservice.service;

import com.intellias.marketplaceservice.db.UserDatabase;
import com.intellias.marketplaceservice.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserDatabase userDatabase;

    public List<User> findAll(){
        log.info("Searching for all users");
        return userDatabase.findAll();
    }
}
