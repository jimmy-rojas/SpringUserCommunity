package com.organization.usercommunity.controller;

import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class CommunityController {

    @Autowired
    private UserService userService;

    //TODO: Do not forget remove this end-point
    @RequestMapping(method=GET, value="/users")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
