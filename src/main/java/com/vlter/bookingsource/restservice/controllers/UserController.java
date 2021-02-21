package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    // Список всех пользователей
    @GetMapping()
    public List getAllUsers() {
        return userService.userRepository.findAll();
    }
}
