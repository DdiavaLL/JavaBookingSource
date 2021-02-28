package com.vlter.bookingsource.restservice.services;

import com.vlter.bookingsource.restservice.exceptions.IncorrectResourceSaveException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchResourceException;
import com.vlter.bookingsource.restservice.models.Resource;
import com.vlter.bookingsource.restservice.repositories.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Service
public class ResourceService {
    @Autowired
    public ResourceRepository resourceRepository;

    public Resource addResource(Resource resource) {
        Resource help = resourceRepository.findByResourceEquals(resource.getResource());
        if (help == null)
            help = saveResource(resource);
        return help;
    }

    public void updateResource(Integer resourceId, Resource resourceDetails) {
        Resource curResource = resourceRepository.findById(resourceId).orElse(null);
        if (curResource == null) {
            throw new ThereIsNoSuchResourceException();
        } else {
            curResource.setResource(resourceDetails.getResource());
            saveResource(curResource);
        }
    }

    private Resource saveResource(Resource newResource) {
        Resource rezultResource;
        try {
            rezultResource = resourceRepository.save(newResource);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectResourceSaveException();
        }
        return rezultResource;
    }

    public void deleteResource(Integer resourceId) throws Exception {
        resourceRepository.delete(resourceRepository.findById(resourceId).orElse(null));
    }
}
