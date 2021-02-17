package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "resources")
public class Resource {
    @Id
    private Integer id;
    private String resource;

    public Resource() { super(); }

    public Resource(Integer id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
