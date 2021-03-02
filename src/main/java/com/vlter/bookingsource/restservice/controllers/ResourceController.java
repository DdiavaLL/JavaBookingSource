package com.vlter.bookingsource.restservice.controllers;

import com.vlter.bookingsource.restservice.exceptions.DeleteResourceException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchResourceException;
import com.vlter.bookingsource.restservice.models.Resource;
import com.vlter.bookingsource.restservice.services.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
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

    // Получить информацию о ресурсе по id
    @GetMapping("/{id}")
    public Resource getResourceById(@PathVariable Integer id) {
        Resource rezResource = resourceService.resourceRepository.findById(id).orElse(null);
        if (rezResource == null) {
            throw new ThereIsNoSuchResourceException();
        }
        return rezResource;
    }

    // Добавление ресурса
    @PostMapping()
    public Serializable postResource(@PathVariable Resource resource) {
        Resource rezResource = resourceService.addResource(resource);
        return rezResource;
    }

    // Изменение информации о ресурсе с указанным id
    @PatchMapping("/{id}")
    public Serializable updateResource(@PathVariable Integer id, @PathVariable Resource resourceDetails) {
        Resource findRez = resourceService.resourceRepository.findById(id).orElse(null);
        resourceService.updateResource(id, resourceDetails);
        return findRez;
    }

    // Удаление записи о ресурсе с указанным id
    @DeleteMapping("/{id}")
    public Serializable deleteUser(@PathVariable Integer id) {
        Resource findRez = resourceService.resourceRepository.findById(id).orElse(null);
        if (findRez == null) {
            throw new ThereIsNoSuchResourceException();
        } else {
            try {
                resourceService.deleteResource(id);
            } catch (Exception e) {
                e.printStackTrace();
                throw new DeleteResourceException();
            }
        }
        return findRez;
    }
}
