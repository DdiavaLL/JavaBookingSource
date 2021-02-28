package com.vlter.bookingsource.restservice.services;

import com.vlter.bookingsource.restservice.exceptions.IncorrectUserSaveException;
import com.vlter.bookingsource.restservice.exceptions.ThereIsNoSuchUserException;
import com.vlter.bookingsource.restservice.models.User;
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

    public User addUser(User user) {
        User help = userRepository.findByUserEquals(user.getUser());
        if (help == null)
            help = saveUser(user);
        return help;
    }

    public void updateUser(Integer userId, User userDetails) {
        User curUser = userRepository.findById(userId).orElse(null);
        if (curUser == null) {
            throw new ThereIsNoSuchUserException();
        }
        else {
            curUser.setUser(userDetails.getUser());
            saveUser(curUser);
        }
    }

    private User saveUser(User newUser) {
        User rezultUser;
        try {
            rezultUser = userRepository.save(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IncorrectUserSaveException();
        }
        return rezultUser;
    }

    public void deleteUser(Integer userId) throws Exception {
        userRepository.delete(userRepository.findById(userId).orElse(null));
    }
}
