package com.usercommunity.repository;

import com.usercommunity.controller.exception.RecipeNotFoundException;
import com.usercommunity.controller.exception.UserNotFoundException;
import com.usercommunity.entity.Recipe;
import com.usercommunity.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserCommunityRepository implements IRepository {

    private static Map<Integer, User> userMap;
    private static Map<Integer, Recipe> recipeMap;
    private static Map<String, User> usernamePassMap;
    private static final AtomicInteger counter = new AtomicInteger();
    private static final AtomicInteger counterRecipe = new AtomicInteger();

    static {
        userMap = new HashMap<>();
        usernamePassMap = new HashMap<>();
        recipeMap = new HashMap<>();
        String username;
        User user;
        for (int i = 0; i<5; i++) {
            username = i+"email@email.com";
            user = new User(i, username, i+"password", i+"user fullName", "13-11-1986");
            userMap.put(i, user);
            usernamePassMap.put(user.getAuthKey(), user);
            counter.incrementAndGet();
            generateRecipeForUser(user);
        }
    }

    private static void generateRecipeForUser(User user) {
        //int id, String title, String receipeData, String createdDate, String modifiedDate, int id_user
        List<Recipe> recipeList = new ArrayList<>();
        for (int i=0; i<5; i++){
            Recipe recipe = new Recipe(counterRecipe.incrementAndGet()
            ,"Recipe-"+i
            , "Recipe Data content-"+i
            , "01-01-2010"
            , "01-01-2010"
            , user.getId());
            recipeMap.put(recipe.getId(), recipe);
            recipeList.add(recipe);
        }
        user.setRecipeList(recipeList);
    }

    @Override
    public Collection<User> getAllUsers() {
        return this.userMap.values();
    }

    @Override
    public User authUser(String username, String password) {
        if (usernamePassMap.containsKey(username+password)) {
            return usernamePassMap.get(username+password);
        } else {
            throw new UserNotFoundException(username);
        }
    }

    @Override
    public boolean createUser(User user) {
        try {
            user.setId(counter.incrementAndGet());
            userMap.put(user.getId(), user);
            usernamePassMap.put(user.getAuthKey(), user);
            return true;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return false;
        }
    }

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
    public boolean createRecipe(Recipe recipe) {
        try {
            recipe.setId(counterRecipe.incrementAndGet());
            recipeMap.put(recipe.getId(), recipe);
            userMap.get(recipe.getId_user()).getRecipeList().add(recipe);
            return true;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateRecipe(Recipe recipe) {
        try {
            recipeMap.put(recipe.getId(), recipe);
            userMap.get(recipe.getId_user()).replaceExistingRecipe(recipe);
            return true;
        } catch (Exception e) {
            System.out.println("Exc: "+ e.getMessage());
            return false;
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
