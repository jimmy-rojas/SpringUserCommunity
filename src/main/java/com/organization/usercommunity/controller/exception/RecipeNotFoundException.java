package com.organization.usercommunity.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends EntityNotFoundException {

    public RecipeNotFoundException(String recipeId) {
        super("Recipe not exist '" + recipeId + "'.");
    }
}
