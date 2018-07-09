package com.usercommunity.repository;

import com.usercommunity.controller.exception.UserNotFoundException;
import com.usercommunity.entity.Recipe;
import com.usercommunity.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserCommunityRepository implements IRepository {

    private static Map<Integer, User> userMap;
    private static Map<String, User> usernamePassMap;
    private static final AtomicInteger counter = new AtomicInteger();

    static {
        userMap = new HashMap<>();
        usernamePassMap = new HashMap<>();
        String username;
        User user;
        for (int i = 0; i<5; i++) {
            username = i+"email@email.com";
            user = new User(i, username, i+"password", i+"user fullName", "13-11-1986");
            userMap.put(i, user);
            usernamePassMap.put(user.getAuthKey(), user);
            counter.incrementAndGet();
        }
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
        user.setId(counter.incrementAndGet());
        userMap.put(user.getId(), user);
        usernamePassMap.put(user.getAuthKey(), user);
        return false;
    }

    @Override
    public Collection<Recipe> getAllRecipes() {
        return null;
    }

    @Override
    public Collection<Recipe> getAllRecipesByUser(int id_user) {
        return null;
    }

    @Override
    public Recipe getRecipeById(int id_recipe) {
        return null;
    }

    @Override
    public boolean createRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean updateRecipe(Recipe recipe) {
        return false;
    }

    @Override
    public boolean deleteRecipe(int id_recipe) {
        return false;
    }

}
