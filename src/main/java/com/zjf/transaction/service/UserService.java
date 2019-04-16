package com.zjf.transaction.service;

import com.zjf.transaction.model.User;

public interface UserService {
    User getUser(String userId);

    void addUser(User user);

    void updateUserPassword(String password, String userId);
}
