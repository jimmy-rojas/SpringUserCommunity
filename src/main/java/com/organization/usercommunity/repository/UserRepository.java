package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.controller.exception.UserNotFoundException;
import com.organization.usercommunity.entity.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("default")
public class UserRepository extends RepositoryCommon implements IUserRepository {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

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
    public User createUser(User user) {
        try {
            user.setId(counter.incrementAndGet());
            userMap.put(user.getId(), user);
            usernamePassMap.put(user.getAuthKey(), user);
            return user;
        } catch (Exception e) {
            log.error("createRecipe error", e);
            return null;
        }
    }

}
