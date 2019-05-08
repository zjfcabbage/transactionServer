package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopcart")
public class ShopcartController {

    @Autowired
    private ShopcartService shopcartService;

    @PostMapping(value = "/add")
    public Data add(String userId, String commodityId) {
        return shopcartService.add(userId, commodityId);
    }

    @GetMapping(value = "/getAll")
    public Data getShopcartItem(String userId, int pageNum) {
        return shopcartService.getShopcartItem(userId, pageNum);
    }

    @DeleteMapping(value = "/delete")
    public Data delete(String userId, String commodity) {
        return shopcartService.delete(userId, commodity);
    }

    @DeleteMapping(value = "/deleteMore")
    public Data deleteMore(String userId, @RequestBody List<String> list) {
        return shopcartService.deleteMore(userId, list);
    }
}
