package com.organization.usercommunity.controller;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserCommunityController {

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

    //TODO: consider: GET /recipe?page=0&pageLimit=10
    @RequestMapping(method=GET, value="/recipes")
    public Collection<Recipe> getAllRecipes(@RequestParam(value="page") String page,
                                            @RequestParam(value="pageLimit") String pageLimit) {
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

    @RequestMapping(method=POST, value="/recipe")
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        return userService.createRecipe(recipe)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=PUT, value="/recipe")
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe) {
        return userService.updateRecipe(recipe)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=DELETE, value="/recipe/{recipeId}")
    public ResponseEntity updateRecipe(@PathVariable int recipeId) {
        return userService.deleteRecipe(recipeId)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
