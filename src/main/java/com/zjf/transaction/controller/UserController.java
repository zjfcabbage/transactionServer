package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public Data login(@RequestParam String userName, @RequestParam String password) {
        return userService.login(userName, password);
    }

    @ResponseBody
    @RequestMapping(value = "/user/exist", method = RequestMethod.GET)
    public Data isUserNameExisted(String userName) {
        return userService.isUserNameExisted(userName);
    }
}
