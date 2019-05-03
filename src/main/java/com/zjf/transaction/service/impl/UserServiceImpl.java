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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_PIC_PATH = "/home/transaction/image";
//        private static final String USER_PIC_PATH = "D:\\test";
    private static final String USER_PIC_URL = "http://47.100.61.176:8080/image/";
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
    public Data uploadUserPic(MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseUtil.error(0, "图片文件不存在");
        }
        String fileName = file.getOriginalFilename();
        if (fileName != null && fileName.length() > 0) {
            String[] fileNames = fileName.split("_");
            String userId = fileNames[0];
            File userPath = new File(USER_PIC_PATH + File.separator + userId);
            if (!userPath.exists()) {
                userPath.mkdirs();
            }
            String userPicUrl = USER_PIC_URL + userId + File.separator + fileName;
            //    /home/transaction/image/{userId}/{fileName}
            File destPath = new File(USER_PIC_PATH + File.separator + userId + File.separator + fileName);
            try {
                file.transferTo(destPath);
                userMapper.updateUserPicUrl(userId, userPicUrl); //更新user表的头像链接
                return ResponseUtil.success(userPicUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseUtil.error(0, "图片上传失败");
    }

    @Override
    public byte[] getUserPic(String userId, String fileName) {
        Path path = Paths.get(USER_PIC_PATH + File.separator + userId + File.separator + fileName);
        byte[] data = null;
        try {
            data = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
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
    public Data getUserPic(String userId) {
        if (userId == null) {
            return ResponseUtil.error(0, "参数错误");
        }
        return ResponseUtil.success(userMapper.getUserPic(userId));
    }
}
