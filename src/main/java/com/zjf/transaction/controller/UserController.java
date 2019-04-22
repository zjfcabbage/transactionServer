package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/user/get")
    public Data getUser(String userId) {
        return userService.getUser(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public Data registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/user/update/password", method = RequestMethod.PUT)
    public Data updateUserPassword(String password, String userId) {
        return userService.updateUserPassword(password, userId);
    }

    @ResponseBody
    @RequestMapping(value = "/user/update/userName", method = RequestMethod.PUT)
    public Data updateUserName(@RequestParam String userName, @RequestParam String userId) {
        return userService.updateUserName(userName, userId);
    }

    @ResponseBody
    @RequestMapping(value = "/user/add/pic", method = RequestMethod.POST)
    public Data uploadUserPic(@RequestParam(value = "image") MultipartFile file) {
        return userService.uploadUserPic(file);
    }

    @ResponseBody
    @RequestMapping(value = "/image/{userId}/{fileName}", method = RequestMethod.GET, produces = {MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_GIF_VALUE})
    public byte[] getUserPic(@PathVariable String userId, @PathVariable String fileName) {
        return userService.getUserPic(userId, fileName);
    }

    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Data login(@RequestParam String userName, @RequestParam String password) {
        return userService.login(userName, password);
    }
}
