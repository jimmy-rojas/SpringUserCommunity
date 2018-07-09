package com.usercommunity.service;

import com.usercommunity.repository.UserCommunityRepository;
import com.usercommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserCommunityRepository userDAO;

    public Collection<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
