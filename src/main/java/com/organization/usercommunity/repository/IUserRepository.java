package com.organization.usercommunity.repository;

import com.organization.usercommunity.entity.User;

import java.util.Collection;

public interface IUserRepository {
    Collection<User> getAllUsers();
    User authUser(String username, String password);
    User createUser(User user);
}
