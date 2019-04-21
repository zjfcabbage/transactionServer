package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/get")
    public Data getUser(String userId) {
        return userService.getUser(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Data registerUser(User user) {
        return userService.registerUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/update/password", method = RequestMethod.PUT)
    public Data updateUserPassword(String password, String userId) {
        return userService.updateUserPassword(password, userId);
    }

    @ResponseBody
    @RequestMapping(value = "/update/userName", method = RequestMethod.PUT)
    public Data updateUserName(String userName, String userId) {
        return userService.updateUserName(userName, userId);
    }

    @ResponseBody
    @RequestMapping(value = "/add/pic", method = RequestMethod.POST)
    public Data uploadUserPic(MultipartFile file) {
        return userService.uploadUserPic(file);
    }
}
