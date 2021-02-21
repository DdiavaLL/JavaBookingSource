package com.vlter.bookingsource.restservice.repositories;

import com.vlter.bookingsource.restservice.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
}
