package com.organization.usercommunity.controller;

import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.entity.UserAuth;
import com.organization.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //TODO: Do not forget remove this end-point
    @RequestMapping(method=GET, value="/")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method=POST, value="/users")
    public User authUser(@RequestBody UserAuth userAuth) {
        return userService.authUser(userAuth.getUsername(), userAuth.getPassword());
    }

    @RequestMapping(method=POST, value="/user")
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
