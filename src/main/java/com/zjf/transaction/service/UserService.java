package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    Data getUser(String userId);

    Data registerUser(User user);

    Data updateUserPassword(String password, String userId);


    Data updateUserName(String userName, String userId);

    Data uploadUserPic(MultipartFile file);

    byte[] getUserPic(String userId, String fileName);

    Data login(String userName, String password);

    Data isUserNameExisted(String userName);

    Data getUserPic(String userId);
}
