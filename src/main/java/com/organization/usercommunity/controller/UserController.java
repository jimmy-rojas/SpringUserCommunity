package com.organization.usercommunity.controller;

import com.organization.usercommunity.controller.exception.UserNotFoundException;
import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.entity.UserAuth;
import com.organization.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=POST, value="/users")
    public User authUser(@RequestBody UserAuth userAuth) throws UserNotFoundException {
        return userService.authUser(userAuth.getUsername(), userAuth.getPassword());
    }

    @RequestMapping(method=GET, value="/user/{userId}")
    public User getUserData(@PathVariable Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    @RequestMapping(method=POST, value="/user")
    public ResponseEntity createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return newUser != null
                ? new ResponseEntity(newUser, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=PUT, value="/user")
    public ResponseEntity updateUser(@RequestBody User user) {
        User newUser = userService.updateUser(user);
        return newUser != null
                ? new ResponseEntity(newUser, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
