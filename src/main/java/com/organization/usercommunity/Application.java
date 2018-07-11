package com.organization.usercommunity;

import com.organization.usercommunity.entity.Recipe;
import com.organization.usercommunity.entity.User;
import com.organization.usercommunity.repository.RecipeRepository;
import com.organization.usercommunity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository,
                           RecipeRepository recipeRepository) {
        return args ->
                Arrays.asList("jhoeller","dsyer","pwebb","ogierke","rwinch","mfisher","mpollack","jlong")
                        .forEach(username -> {
                            User user = userRepository.save(new User(username, "password", username+" fullname", "11-13-1986"));
                            recipeRepository.save(new Recipe("Recipe Title 1 for " + username, "Recipe data 1" + username, "01-01-2010", "01-01-2010", user));
                            recipeRepository.save(new Recipe("Recipe Title 2 for " + username, "Recipe data 1" + username, "01-01-2010", "01-01-2010", user));
                        });
    }
}
