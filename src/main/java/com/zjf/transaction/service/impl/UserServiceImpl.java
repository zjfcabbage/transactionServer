package com.zjf.transaction.service.impl;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.mapper.UserMapper;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_PIC_PATH = "D://test";

    @Autowired
    private UserMapper userMapper;

    @Override
    public Data getUser(String userId) {
        return ResponseUtil.success(userMapper.getUser(userId));
    }

    @Override
    public Data registerUser(User user) {
        if (user != null) {
            final String userName = user.getUserId();//客户端保证userId唯一
            if (userName == null || userName.length() == 0) {
                return ResponseUtil.error(0, "参数错误");
            }
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
                userPath.mkdir();
            }
            String userPicUrl = userPath + fileName;
            File destPath = new File(userPicUrl);
            try {
                file.transferTo(destPath);
                return ResponseUtil.success(userPicUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseUtil.error(0, "图片上传失败");
    }
}
