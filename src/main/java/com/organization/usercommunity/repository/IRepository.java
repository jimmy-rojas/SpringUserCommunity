package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;

import java.util.Collection;

public interface IRepository {

    Collection<User> getAllUsers();
    User authUser(String username, String password);
    boolean createUser(User user);

    Collection<Recipe> getAllRecipes();
    Collection<Recipe> getAllRecipesByUser(int id_user);
    Recipe getRecipeById(int id_recipe);

    boolean createRecipe(Recipe recipe);
    boolean updateRecipe(Recipe recipe);
    boolean deleteRecipe(int id_recipe);
}