package com.usercommunity.controller;

import com.usercommunity.entity.Recipe;
import com.usercommunity.entity.User;
import com.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class UserCommunityController {

    @Autowired
    private UserService userService;

    //TODO: Do not forget remove this end-point
    @RequestMapping(method=GET, value="/")
    public Collection<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method=GET, value="/user")
    public User authUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        return userService.authUser(username, password);
    }

    @RequestMapping(method=POST, value="/user")
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //TODO: consider: GET /recipe?page=0&pageLimit=10
    @RequestMapping(method=GET, value="/recipes")
    public Collection<Recipe> getAllRecipes(@RequestParam(value="page") String page, @RequestParam(value="pageLimit") String pageLimit) {
        //TODO: use page and pageLimit params
        return userService.getAllRecipes();
    }

    //TODO: consider: GET /recipe/userId?page=0&pageLimit=10
    @RequestMapping(method=GET, value="/recipes/{userId}")
    public Collection<Recipe> getAllRecipesByUserId(@PathVariable int userId) {
        //TODO: use page and pageLimit params
        return userService.getAllRecipesByUser(userId);
    }

    @RequestMapping(method=GET, value="/recipe/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return userService.getRecipeById(recipeId);
    }
}
