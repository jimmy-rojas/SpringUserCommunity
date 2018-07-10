package com.organization.usercommunity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class User {
    private int id;
    private String email;
    @JsonIgnore
    private String password;
    private String fullName;
    private String dateOfBirth;
    private List<Recipe> recipeList;

    public User(int id, String email, String password, String fullName, String dateOfBirth) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @JsonIgnore
    public String getAuthKey() {
        return getEmail() + getPassword();
    }

    public void replaceExistingRecipe(Recipe recipe) {
        int index = recipeList.indexOf(recipe);
        recipeList.remove(index);
        recipeList.add(index, recipe);
    }
}
