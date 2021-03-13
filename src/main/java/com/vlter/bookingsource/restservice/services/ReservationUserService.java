package com.vlter.bookingsource.restservice.services;

import com.vlter.bookingsource.restservice.exceptions.IncorrectUserSaveException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchUserException;
import com.vlter.bookingsource.restservice.models.ReservationUser;
import com.vlter.bookingsource.restservice.repositories.ReservationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Service
public class ReservationUserService {
    @Autowired
    public ReservationUserRepository reservationUserRepository;

    public ReservationUser addUser(ReservationUser reservationUser) {
        ReservationUser help = reservationUserRepository.findByReservationuserEquals(reservationUser.getReservationuser());
        if (help == null)
            help = saveUser(reservationUser);
        return help;
    }

    public void updateUser(Integer userId, ReservationUser reservationUserDetails) {
        ReservationUser curReservationUser = reservationUserRepository.findById(userId).orElse(null);
        if (curReservationUser == null) {
            throw new ThereIsNoSuchUserException();
        }
        else {
            curReservationUser.setReservationuser(reservationUserDetails.getReservationuser());
            saveUser(curReservationUser);
        }
    }

    private ReservationUser saveUser(ReservationUser newReservationUser) {
        ReservationUser rezultReservationUser;
        try {
            rezultReservationUser = reservationUserRepository.save(newReservationUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectUserSaveException();
        }
        return rezultReservationUser;
    }

    public void deleteUser(Integer userId) throws Exception {
        reservationUserRepository.delete(reservationUserRepository.findById(userId).orElse(null));
    }
}
