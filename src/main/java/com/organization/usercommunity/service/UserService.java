package com.organization.usercommunity.service;

import com.organization.usercommunity.controller.exception.UserNotFoundException;
import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User authUser(String username, String password) {
        User user = userRepository.findByEmail(username);
        if (user != null && user.getPassword().equalsIgnoreCase(password)) {
            return user;
        } else {
            throw new UserNotFoundException(username);
        }
    }

    public User getUser(Long userId) {
        if (userRepository.existsById(userId)) {
            return userRepository.findById(userId).get();
        } else {
            throw new UserNotFoundException("UserId:"+userId);
        }
    }

    public User createUser(User user) {
        //TODO: check unique username here
        userRepository.save(user);
        return user;
    }

    public User updateUser(User user) {
        //TODO: check id present here
        userRepository.save(user);
        return user;
    }
}
