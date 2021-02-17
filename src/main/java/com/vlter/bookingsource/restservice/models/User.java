package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    private Integer id;
    private String user;

    public User() {
        super();
    }

    public User(Integer id, String user) {
        this.id = id;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
