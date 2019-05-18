package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Order;
import com.zjf.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Data addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @GetMapping("/get")
    public Data getOrder(String userId, int pageNum) {
        return orderService.getOrder(userId, pageNum);
    }

    @DeleteMapping("/delete")
    public Data deleteOrder(String orderId, String userId) {
        return orderService.deleteOrder(userId, orderId);
    }
}
