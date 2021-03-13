package com.vlter.bookingsource.restservice.repositories;

import com.vlter.bookingsource.restservice.models.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Repository
public interface ReservationUserRepository extends JpaRepository<ReservationUser, Integer>{
    ReservationUser findByReservationuserEquals(String user);
}
