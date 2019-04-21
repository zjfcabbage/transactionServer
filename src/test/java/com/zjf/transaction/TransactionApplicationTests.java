package com.zjf.transaction;

import com.zjf.transaction.model.User;
import com.zjf.transaction.service.UserService;
import com.zjf.transaction.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTests {

    @Test
    public void contextLoads() {
    }

//    @Autowired
//    private UserServiceImpl userService;
//
//    @Test
//    public void testRegisterUser() {
//        User user = new User();
//        user.setUserId("222");
//        user.setUserName("aaa");
//        user.setPassword("222");
//        user.setProvince("北京");
//        user.setCity("北京市");
//        user.setUniversity("北京大学");
//        user.setUserPicUrl(null);
//        userService.registerUser(user);
//    }
//
//    @Test
//    public void testUpdatePassword() {
//        userService.updateUserPassword("222", "111");
//    }
//
//
//    @Test
//    public void testUpdateUserName() {
//        userService.updateUserName("aaa", "111");
//    }

}
