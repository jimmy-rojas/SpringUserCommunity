package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryCommon {

    protected static Map<Integer, User> userMap;
    protected static Map<Integer, Recipe> recipeMap;
    protected static Map<String, User> usernamePassMap;
    protected static final AtomicInteger counter = new AtomicInteger();
    protected static final AtomicInteger counterRecipe = new AtomicInteger();

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

}
