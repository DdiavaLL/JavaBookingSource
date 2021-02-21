package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;
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
    private Integer id;
    private Resource resource;
    private User user;
    private LocalDate date;
    private LocalTime duration;

    public Reservation() {
        super();
    }

    public Reservation(Integer id, Resource resource, User user, LocalDate date, LocalTime duration) {
        this.id = id;
        this.resource = resource;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }
}
