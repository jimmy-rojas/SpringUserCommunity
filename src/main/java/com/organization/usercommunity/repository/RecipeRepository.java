package com.organization.usercommunity.repository;

import com.organization.usercommunity.controller.exception.RecipeNotFoundException;
import com.organization.usercommunity.controller.exception.UserNotFoundException;
import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@Qualifier("MockData")
public class RecipeRepository extends RepositoryCommon implements IRecipeRepository {

    @Override
    public Collection<Recipe> getAllRecipes() {
        return recipeMap.values();
    }

    @Override
    public Collection<Recipe> getAllRecipesByUser(int id_user) {
        return userMap.get(id_user).getRecipeList();
    }

    @Override
    public Recipe getRecipeById(int id_recipe) {
        if (recipeMap.containsKey(id_recipe)) {
            return recipeMap.get(id_recipe);
        } else {
            throw new RecipeNotFoundException("RecipeId:"+id_recipe);
        }
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        try {
            recipe.setId(counterRecipe.incrementAndGet());
            recipeMap.put(recipe.getId(), recipe);
            userMap.get(recipe.getId_user()).getRecipeList().add(recipe);
            return recipe;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return null;
        }
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        try {
            recipeMap.put(recipe.getId(), recipe);
            userMap.get(recipe.getId_user()).replaceExistingRecipe(recipe);
            return recipe;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteRecipe(int id_recipe) {
        try {
            Recipe tempRecipe = recipeMap.get(id_recipe);
            tempRecipe.setId(id_recipe);
            int index = userMap.get(tempRecipe.getId_user()).getRecipeList().indexOf(tempRecipe);
            userMap.get(tempRecipe.getId_user()).getRecipeList().remove(index);
            recipeMap.remove(id_recipe);
            return true;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return false;
        }
    }

}
