package com.vlter.bookingsource.restservice.services;

import com.vlter.bookingsource.restservice.exceptions.IncorrectReservationSaveException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchReservationException;
import com.vlter.bookingsource.restservice.models.Reservation;
import com.vlter.bookingsource.restservice.models.Resource;
import com.vlter.bookingsource.restservice.models.User;
import com.vlter.bookingsource.restservice.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Service
public class ReservationService {
    @Autowired
    public ReservationRepository reservationRepository;

    @Autowired
    UserService userService;
    @Autowired
    ResourceService resourceService;

    public Reservation addReservation(Reservation reservation) {
        User helpUser = userService.addUser(reservation.getUser());
        Resource helpResource = resourceService.addResource(reservation.getResource());
        return saveReservation(reservation, helpUser, helpResource);
    }

    public void updateReservation(Integer reservationId, Reservation reservationDetails) {
        Reservation curReservation = reservationRepository.findById(reservationId).orElse(null);
        if (curReservation == null) {
            throw new ThereIsNoSuchReservationException();
        } else {
            User curUser = reservationDetails.getUser();
            User helpUser = userService.addUser(curUser);
            Resource curResource = reservationDetails.getResource();
            Resource helpResource = resourceService.addResource(curResource);
            curReservation.setResource(reservationDetails.getResource());
            curReservation.setUser(reservationDetails.getUser());
            curReservation.setDate(reservationDetails.getDate());
            curReservation.setDuration(reservationDetails.getDuration());
        }
    }

    private Reservation saveReservation(Reservation newReservation, User helpUser, Resource helpResource) {
        Reservation rezReservation;
        try {
            newReservation.setUser(helpUser);
            newReservation.setResource(helpResource);
            rezReservation = reservationRepository.save(newReservation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectReservationSaveException();
        }
        return rezReservation;
    }

    public void deleteReservation(Integer reservationId) throws Exception {
        Reservation findRez = reservationRepository.findById(reservationId).orElse(null);
        List<Reservation> userClones = reservationRepository.findByUserIs(findRez.getUser());
        List<Reservation> resourseClones = reservationRepository.findByResourceIs(findRez.getResource());
        if (userClones.size() > 1 || resourseClones.size() > 1) {
            findRez.setUser(null);
            findRez.setResource(null);
        }
        reservationRepository.delete(findRez);
    }
}
