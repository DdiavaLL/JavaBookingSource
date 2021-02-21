package com.vlter.bookingsource.restservice.services;

import com.vlter.bookingsource.restservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tereshchenko on 21.02.2021.
 */

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
}
