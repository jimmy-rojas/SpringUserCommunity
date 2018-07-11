package com.organization.usercommunity.service;

import com.organization.usercommunity.controller.exception.RecipeNotFoundException;
import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.repository.RecipeRepository;
import com.organization.usercommunity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    public Collection<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Collection<Recipe> getAllRecipesByUser(Long id_user) {
        return recipeRepository.findByUserId(id_user);
    }

    public Recipe getRecipeById(Long id_recipe) {
        if (recipeRepository.existsById(id_recipe)) {
            return recipeRepository.findById(id_recipe).get();
        } else {
            throw new RecipeNotFoundException("RecipeId:"+id_recipe);
        }
    }

    public Recipe createRecipe(Recipe recipe) {
        User user = userRepository.findById(recipe.getUser().getId()).get();
        //TODO: check id present here
        recipe.setUser(user);
        recipeRepository.save(recipe);
        return recipe;
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(Long id_recipe) {
        recipeRepository.deleteById(id_recipe);
    }
}
