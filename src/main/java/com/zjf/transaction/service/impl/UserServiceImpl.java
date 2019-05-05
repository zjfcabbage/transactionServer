package com.zjf.transaction.service.impl;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.mapper.UserMapper;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

        private static final String USER_PIC_PATH = "/home/transaction/image";
//    private static final String USER_PIC_PATH = "D:\\test";
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private UserMapper userMapper;

    @Override
    public Data getUser(String userId) {
        return ResponseUtil.success(userMapper.getUser(userId));
    }

    @Override
    public Data registerUser(User user) {
        if (user != null) {
            logger.debug(user.toString());
            if (userMapper.isUserNameExisted(user.getUserName()) != null) {
                return ResponseUtil.error(0, "用户名已存在");
            }
            userMapper.registerUser(
                    user.getUserId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getUserPicUrl(),  //null
                    user.getProvince(),
                    user.getCity(),
                    user.getUniversity());
            return ResponseUtil.success(userMapper.getUser(user.getUserId()));
        } else {
            return ResponseUtil.error(0, "参数错误");
        }
    }

    @Override
    public Data updateUserPassword(String password, String userId) {
        userMapper.updateUserPassword(password, userId);
        return ResponseUtil.success();
    }


    @Override
    public Data updateUserName(String userName, String userId) {
        if (userName == null || userId == null) {
            return ResponseUtil.error(0, "参数错误");
        } else if (userMapper.isUserNameExisted(userName) != null) {
            return ResponseUtil.error(0, "用户名已存在");
        }
        userMapper.updateUserName(userName, userId);
        return ResponseUtil.success();
    }

    @Override
    public Data login(String userName, String password) {
        if (userName == null || password == null) {
            return ResponseUtil.error(0, "参数错误");
        }
        return ResponseUtil.success(userMapper.login(userName, password));
    }

    @Override
    public Data isUserNameExisted(String userName) {
        if (userName == null) {
            return ResponseUtil.error(0, "userName is null");
        }
        return ResponseUtil.success(userMapper.isUserNameExisted(userName));
    }

    @Override
    public Data updateUserPic(String userId, String userPicUrl) {
        if (userId == null || userPicUrl == null) {
            return ResponseUtil.error(0, "参数错误");
        }
        userMapper.updateUserPicUrl(userId, userPicUrl);
        return ResponseUtil.success();
    }
}
