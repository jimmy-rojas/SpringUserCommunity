package com.organization.usercommunity.controller;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class UserRecipeController {

    @Autowired
    private RecipeService recipeService;

    //TODO: consider: GET /recipe?page=0&pageLimit=10
    @RequestMapping(method=GET, value="/recipes")
    public Collection<Recipe> getAllRecipes(@RequestParam(value="page") String page,
                                            @RequestParam(value="pageLimit") String pageLimit) {
        //TODO: use page and pageLimit params
        return recipeService.getAllRecipes();
    }

    //TODO: consider: GET /recipe/userId?page=0&pageLimit=10
    @RequestMapping(method=GET, value="/recipes/{userId}")
    public Collection<Recipe> getAllRecipesByUserId(@PathVariable int userId) {
        //TODO: use page and pageLimit params
        return recipeService.getAllRecipesByUser(userId);
    }

    @RequestMapping(method=GET, value="/recipe/{recipeId}")
    public Recipe getRecipeById(@PathVariable int recipeId) {
        return recipeService.getRecipeById(recipeId);
    }

    @RequestMapping(method=POST, value="/recipe")
    public ResponseEntity createRecipe(@RequestBody Recipe recipe) {
        Recipe newRecipe = recipeService.createRecipe(recipe);
        return newRecipe != null ? new ResponseEntity(newRecipe, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=PUT, value="/recipe")
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeService.updateRecipe(recipe);
        return updatedRecipe != null ? new ResponseEntity(updatedRecipe, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(method=DELETE, value="/recipe/{recipeId}")
    public ResponseEntity updateRecipe(@PathVariable int recipeId) {
        return recipeService.deleteRecipe(recipeId)
                ? new ResponseEntity(HttpStatus.OK)
                : new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
