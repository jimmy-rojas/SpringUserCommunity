package com.organization.usercommunity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Recipe {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String receipeData;
    private String createdDate;
    private String modifiedDate;

//    @JsonIgnore
    @ManyToOne
    private User user;

    public Recipe(String title, String receipeData, String createdDate, String modifiedDate, User user) {
        this.title = title;
        this.receipeData = receipeData;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.user = user;
    }

    private Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReceipeData() {
        return receipeData;
    }

    public void setReceipeData(String receipeData) {
        this.receipeData = receipeData;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
