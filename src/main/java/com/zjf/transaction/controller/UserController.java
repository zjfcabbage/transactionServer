package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/get")
    public Data getUser(String userId) {
        return ResponseUtil.success(userService.getUser(userId));
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Data addUser(User user) {
        userService.addUser(user);
        return ResponseUtil.success();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Data updateUserPassword(String password, String userId) {
        userService.updateUserPassword(password, userId);
        return ResponseUtil.success();
    }
}
