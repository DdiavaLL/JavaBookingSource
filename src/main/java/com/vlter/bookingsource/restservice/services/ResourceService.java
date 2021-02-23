package com.vlter.bookingsource.restservice.services;

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
}
