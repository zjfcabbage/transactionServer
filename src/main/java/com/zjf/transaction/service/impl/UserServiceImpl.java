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
            userMapper.registerUser(
                    user.getUserId(),
                    user.getUserName(),
                    user.getPassword(),
                    user.getUserPicUrl(),
                    user.getProvince(),
                    user.getCity(),
                    user.getUniversity());
            return ResponseUtil.success();
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
            File destPath = new File(USER_PIC_PATH + File.separator + fileName);
            try {
                file.transferTo(destPath);
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
}
