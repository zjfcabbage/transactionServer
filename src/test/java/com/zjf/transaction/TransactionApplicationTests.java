package com.zjf.transaction;

import com.zjf.transaction.service.ShopcartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionApplicationTests {

    @Test
    public void contextLoads() {
    }

//    @Autowired
//    private ShopcartService shopcartService;
//
//    @Test
//    public void delete() {
//        List<String> strings = new ArrayList<>();
//        strings.add("aaa");
//        strings.add("bbb");
//        strings.add("ccc");
//        shopcartService.deleteMore("444", strings);
//    }
}
