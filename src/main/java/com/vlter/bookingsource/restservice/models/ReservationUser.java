package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "reservationusers")
public class ReservationUser implements Serializable {
    @Id
    @SequenceGenerator(name = "reservationusersSeq", sequenceName = "reservationusers_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationusersSeq")
    private Integer id;

    @Size(max = 100, message = "Данные пользователя должны быть не длинее 100 символов!")
    @NotBlank(message = "Во входящем запросе отсутствуют данные пользователя!")
    private String reservationuser;

    public ReservationUser() {
        super();
    }

    public ReservationUser(Integer id, String reservationuser) {
        this.id = id;
        this.reservationuser = reservationuser;
    }

    public ReservationUser(String reservationuser) { this.reservationuser = reservationuser; }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservationuser() {
        return reservationuser;
    }

    public void setReservationuser(String reservationuser) {
        this.reservationuser = reservationuser;
    }
}
