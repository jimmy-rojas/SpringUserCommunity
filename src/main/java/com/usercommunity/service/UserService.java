package com.usercommunity.service;

import com.usercommunity.entity.Recipe;
import com.usercommunity.repository.IRepository;
import com.usercommunity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private IRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User authUser(String username, String password) {
        return userRepository.authUser(username, password);
    }

    public boolean createUser(User user) {
        return userRepository.createUser(user);
    }

    public Collection<Recipe> getAllRecipes() {
        return userRepository.getAllRecipes();
    }

    public Collection<Recipe> getAllRecipesByUser(int id_user) {
        return userRepository.getAllRecipesByUser(id_user);
    }

    public Recipe getRecipeById(int id_recipe) {
        return userRepository.getRecipeById(id_recipe);
    }

    public boolean createRecipe(Recipe recipe) {
        return userRepository.createRecipe(recipe);
    }

    public boolean updateRecipe(Recipe recipe) {
        return userRepository.updateRecipe(recipe);
    }

    public boolean deleteRecipe(int id_recipe) {
        return userRepository.deleteRecipe(id_recipe);
    }

}
