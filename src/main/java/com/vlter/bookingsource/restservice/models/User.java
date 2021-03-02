package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "usersSeq", sequenceName = "users_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersSeq")
    private Integer id;

    @Size(max = 100, message = "Данные пользователя должны быть не длинее 100 символов!")
    @NotBlank(message = "Во входящем запросе отсутствуют данные пользователя!")
    private String user;

    public User() {
        super();
    }

    public User(Integer id, String user) {
        this.id = id;
        this.user = user;
    }

    public User(String user) { this.user = user; }

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
