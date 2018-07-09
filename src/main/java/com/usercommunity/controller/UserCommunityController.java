package com.usercommunity.controller;

import com.usercommunity.entity.User;
import com.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserCommunityController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
