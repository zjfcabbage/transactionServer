package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.User;

public interface UserService {
    Data getUser(String userId);

    Data registerUser(User user);

    Data updateUserPassword(String password, String userId);

    Data updateUserName(String userName, String userId);

    Data login(String userName, String password);

    Data isUserNameExisted(String userName);

    Data updateUserPic(String userId, String userPicUrl);
}
