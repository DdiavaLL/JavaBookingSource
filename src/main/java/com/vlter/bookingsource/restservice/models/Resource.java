package com.vlter.bookingsource.restservice.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by Tereshchenko on 17.02.2021.
 */

@Entity
@Table(name = "resources")
public class Resource implements Serializable {
    @Id
    @SequenceGenerator(name = "resourcesSeq", sequenceName = "resources_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resourcesSeq")
    private Integer id;

    @Size(max = 100, message = "Ресурс должен быть не длинее 100 символов!")
    @NotBlank(message = "Во входящем запросе отсутствует ресурс!")
    private String resource;

    public Resource() { super(); }

    public Resource(Integer id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    public Resource(String resource) { this.resource = resource; }

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
