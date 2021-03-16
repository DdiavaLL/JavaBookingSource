package com.vlter.bookingsource.restservice.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable{
    @Id
    @SequenceGenerator(name = "reservationsSeq", sequenceName = "reservations_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservationsSeq")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id", nullable = false)
    @NotNull(message = "Во входящем запросе отсутствует ресурс, который необходимо зарезервировать!")
    private Resource resource;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "reservationuser_id", nullable = false)
    @NotNull(message = "Во входящем запросе отсутствует пользователь, резирвирующий ресурс!")
    private ReservationUser reservationuser;

    @NotNull(message = "Во входящем запросе отсутствует дата резервирования ресурса!")
    private LocalDate date;

    @NotNull(message = "Во входящем запросе отсутствует длительность резервирования ресурса!")
    private LocalTime duration;

    public Reservation() {
        super();
    }

    public Reservation(Integer id, Resource resource, ReservationUser reservationuser, LocalDate date, LocalTime duration) {
        this.id = id;
        this.resource = resource;
        this.reservationuser = reservationuser;
        this.date = date;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public ReservationUser getReservationuser() {
        return reservationuser;
    }

    public void setReservationuser(ReservationUser reservationuser) {
        this.reservationuser = reservationuser;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    public LocalTime getDuration() {
        return duration;
    }
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
