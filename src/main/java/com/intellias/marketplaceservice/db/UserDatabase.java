package com.intellias.marketplaceservice.db;

import com.intellias.marketplaceservice.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDatabase {

    private List<User> users = new ArrayList<>();

    public List<User> findAll(){
        return users;
    }

    public void save(User user){
        users.add(user);
    }

}
