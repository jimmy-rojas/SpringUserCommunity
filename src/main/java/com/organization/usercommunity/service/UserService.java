package com.organization.usercommunity.service;

import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User authUser(String username, String password) {
        return userRepository.authUser(username, password);
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }
}
