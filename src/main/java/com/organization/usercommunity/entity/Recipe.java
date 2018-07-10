package com.organization.usercommunity.entity;

public class Recipe {
    private int id;
    private String title;
    private String receipeData;
    private String createdDate;
    private String modifiedDate;
    private int id_user;

    public Recipe(int id, String title, String receipeData, String createdDate, String modifiedDate, int id_user) {
        this.id = id;
        this.title = title;
        this.receipeData = receipeData;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.id_user = id_user;
    }

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) o;
        return id == other.getId();
    }

    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }
}
