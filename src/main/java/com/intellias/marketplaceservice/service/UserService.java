package com.intellias.marketplaceservice.service;

import com.intellias.marketplaceservice.db.UserDatabase;
import com.intellias.marketplaceservice.dto.UserDto;
import com.intellias.marketplaceservice.exception.UserValidationException;
import com.intellias.marketplaceservice.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserDatabase userDatabase;

    public List<User> findAll(){
        log.info("Searching for all users");
        return userDatabase.findAll();
    }
    public void add(UserDto userDto) {
        log.info("Adding user");
        if(userDto.getFirstName().isEmpty() || userDto.getLastName().isEmpty()) {
            log.error("First name or last name empty");

            throw new UserValidationException("First name or last name is empty");
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAmountOfMoney(userDto.getAmountOfMoney());
        user.setId(UUID.randomUUID());

        userDatabase.save(user);
    }
}
