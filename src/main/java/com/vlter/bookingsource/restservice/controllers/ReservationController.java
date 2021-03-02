package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.DeleteReservationException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchReservationException;
import com.vlter.bookingsource.restservice.models.Reservation;
import com.vlter.bookingsource.restservice.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tereshchenko on 23.02.2021.
 */

@RestController
@RequestMapping(value = "/api/reservations")
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    // Список всех зарезервированных ресурсов
    @GetMapping()
    public List getAllUsers() {
        return reservationService.reservationRepository.findAll();
    }

    // Получить информацию о зарезервированном ресурсе по id
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Integer id) {
        Reservation rezReservation = reservationService.reservationRepository.findById(id).orElse(null);
        if (rezReservation == null) {
            throw new ThereIsNoSuchReservationException();
        }
        return rezReservation;
    }

    // Добавление записи о зарезервированном ресурсе
    @PostMapping()
    public Serializable postReservation(@RequestBody Reservation reservation) {
        Reservation rezReservation = reservationService.addReservation(reservation);
        return rezReservation;
    }

    // Изменение информации о зарезервированном ресурсе с указанным id
    @PatchMapping("/{id}")
    public Serializable updateReservation(@PathVariable Integer id, @RequestBody Reservation reservationDetails) {
        Reservation findRez = reservationService.reservationRepository.findById(id).orElse(null);
        reservationService.updateReservation(id, reservationDetails);
        return findRez;
    }

    // Удаление записи о зарезервированном ресурсе с указанным id
    @DeleteMapping("/{id}")
    public Serializable deleteReservation(@PathVariable Integer id) {
        Reservation findRez = reservationService.reservationRepository.findById(id).orElse(null);
        if (findRez == null) {
            throw new ThereIsNoSuchReservationException();
        } else {
            try {
                reservationService.deleteReservation(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DeleteReservationException();
            }
        }
        return findRez;
    }
}
