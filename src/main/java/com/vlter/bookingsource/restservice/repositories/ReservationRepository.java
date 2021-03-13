package com.vlter.bookingsource.restservice.repositories;

import com.vlter.bookingsource.restservice.models.Reservation;
import com.vlter.bookingsource.restservice.models.Resource;
import com.vlter.bookingsource.restservice.models.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    List<Reservation> findByReservationuserIs(ReservationUser reservationUser);
    List<Reservation> findByResourceIs(Resource resource);
}
