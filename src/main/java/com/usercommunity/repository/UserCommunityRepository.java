package com.usercommunity.repository;

import com.usercommunity.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserCommunityRepository {

    private static Map<Integer, User> userMap;
    private static Map<String, User> usernameMap;

    static {
        userMap = new HashMap<>();
        usernameMap = new HashMap<>();
        String username;
        User user;
        for (int i = 0; i<5; i++) {
            username = i+"email@email.com";
            user = new User(i, username, i+"password", i+"user fullName", "13-11-1986");
            userMap.put(i, user);
            usernameMap.put(username, user);
        }
    }

    public Collection<User> getAllUsers() {
        return this.userMap.values();
    }

}
