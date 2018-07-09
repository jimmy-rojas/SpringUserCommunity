package com.usercommunity.service;

import com.usercommunity.repository.IRepository;
import com.usercommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private IRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User authUser(String username, String password) {
        return userRepository.authUser(username, password);
    }
}
