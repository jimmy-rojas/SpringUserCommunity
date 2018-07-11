package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Collection<Recipe> findByUserId(Long id);
}
