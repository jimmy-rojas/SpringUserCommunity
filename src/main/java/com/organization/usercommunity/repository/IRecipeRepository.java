package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.Recipe;

import java.util.Collection;

public interface IRecipeRepository {
    Collection<Recipe> getAllRecipes();
    Collection<Recipe> getAllRecipesByUser(int id_user);
    Recipe getRecipeById(int id_recipe);
    Recipe createRecipe(Recipe recipe);
    Recipe updateRecipe(Recipe recipe);
    boolean deleteRecipe(int id_recipe);
}
