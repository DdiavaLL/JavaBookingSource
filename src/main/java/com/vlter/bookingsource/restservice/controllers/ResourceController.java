package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tereshchenko on 23.02.2021.
 */

@RestController
@RequestMapping(value = "/api/resources")
public class ResourceController {
    @Autowired
    ResourceService resourceService;

    // Список всех ресурсов
    @GetMapping()
    public List getAllUsers() {
        return resourceService.resourceRepository.findAll();
    }
}
