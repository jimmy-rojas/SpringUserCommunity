package com.organization.usercommunity.service;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.repository.IRecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RecipeService {

    @Autowired
    private IRecipeRepository userRepository;

    public Collection<Recipe> getAllRecipes() {
        return userRepository.getAllRecipes();
    }

    public Collection<Recipe> getAllRecipesByUser(int id_user) {
        return userRepository.getAllRecipesByUser(id_user);
    }

    public Recipe getRecipeById(int id_recipe) {
        return userRepository.getRecipeById(id_recipe);
    }

    public Recipe createRecipe(Recipe recipe) {
        return userRepository.createRecipe(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return userRepository.updateRecipe(recipe);
    }

    public boolean deleteRecipe(int id_recipe) {
        return userRepository.deleteRecipe(id_recipe);
    }
}
