package com.usercommunity.controller;

import com.usercommunity.entity.User;
import com.usercommunity.repository.IRepository;
import com.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class UserCommunityController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=GET, value="/")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method=GET, value="/user")
    public User authUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        System.out.println("u:"+username+" p:"+password);
        return userService.authUser(username, password);
    }
}
