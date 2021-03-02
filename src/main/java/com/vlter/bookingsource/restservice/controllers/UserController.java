package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.DeleteUserException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchUserException;
import com.vlter.bookingsource.restservice.models.User;
import com.vlter.bookingsource.restservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
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

    // Получить информацию о пользователе по id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        User rezUser = userService.userRepository.findById(id).orElse(null);
        if (rezUser == null) {
            throw new ThereIsNoSuchUserException();
        }
        return rezUser;
    }

    // Добавление пользователя
    @PostMapping()
    public Serializable postUser(@RequestBody User user) {
        User rezUser = userService.addUser(user);
        return rezUser;
    }

    // Изменение информации о пользователе с указанным id
    @PatchMapping("/{id}")
    public Serializable updateUser(@PathVariable Integer id, @PathVariable User userDetails) {
        User findRez = userService.userRepository.findById(id).orElse(null);
        userService.updateUser(id, userDetails);
        return findRez;
    }

    // Удаление записи о пользователе с указанным id
    @DeleteMapping("/{id}")
    public Serializable deleteUser(@PathVariable Integer id) {
        User findRez = userService.userRepository.findById(id).orElse(null);
        if (findRez == null) {
            throw new ThereIsNoSuchUserException();
        } else {
            try {
                userService.deleteUser(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DeleteUserException();
            }
        }
        return findRez;
    }
}
