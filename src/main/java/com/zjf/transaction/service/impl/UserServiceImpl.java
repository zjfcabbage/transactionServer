package com.zjf.transaction.service.impl;

import com.zjf.transaction.mapper.UserMapper;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void updateUserPassword(String password, String userId) {
        userMapper.updateUserPassword(password, userId);
    }
}
