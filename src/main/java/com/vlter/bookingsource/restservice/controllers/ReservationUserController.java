package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.DeleteUserException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchUserException;
import com.vlter.bookingsource.restservice.models.ReservationUser;
import com.vlter.bookingsource.restservice.services.ReservationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@RestController
@RequestMapping(value = "/api/reservationusers")
public class ReservationUserController {
    @Autowired
    ReservationUserService reservationUserService;

    // Список всех пользователей
    @GetMapping()
    public List getAllUsers() {
        return reservationUserService.reservationUserRepository.findAll();
    }

    // Получить информацию о пользователе по id
    @GetMapping("/{id}")
    public ReservationUser getUserById(@PathVariable Integer id) {
        ReservationUser rezReservationUser = reservationUserService.reservationUserRepository.findById(id).orElse(null);
        if (rezReservationUser == null) {
            throw new ThereIsNoSuchUserException();
        }
        return rezReservationUser;
    }

    // Добавление пользователя
    @PostMapping()
    public Serializable postUser(@RequestBody ReservationUser reservationUser) {
        ReservationUser rezReservationUser = reservationUserService.addUser(reservationUser);
        return rezReservationUser;
    }

    // Изменение информации о пользователе с указанным id
    @PatchMapping("/{id}")
    public Serializable updateUser(@PathVariable Integer id, @PathVariable ReservationUser reservationUserDetails) {
        ReservationUser findRez = reservationUserService.reservationUserRepository.findById(id).orElse(null);
        reservationUserService.updateUser(id, reservationUserDetails);
        return findRez;
    }

    // Удаление записи о пользователе с указанным id
    @DeleteMapping("/{id}")
    public Serializable deleteUser(@PathVariable Integer id) {
        ReservationUser findRez = reservationUserService.reservationUserRepository.findById(id).orElse(null);
        if (findRez == null) {
            throw new ThereIsNoSuchUserException();
        } else {
            try {
                reservationUserService.deleteUser(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DeleteUserException();
            }
        }
        return findRez;
    }
}
