package com.organization.usercommunity.entity;

import javax.validation.constraints.NotBlank;

public class UserAuth {
    @NotBlank(message = "UserName must not be blank.")
    private String username;
    @NotBlank(message = "Password must not be blank")
    private String password;

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
