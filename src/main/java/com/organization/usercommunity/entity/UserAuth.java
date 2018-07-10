package com.organization.usercommunity.entity;

public class UserAuth {
    String username;
    String password;

    public UserAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserAuth() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
