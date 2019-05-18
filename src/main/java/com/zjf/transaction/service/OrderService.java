package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Order;

public interface OrderService {
    Data addOrder(Order order);

    Data getOrder(String userId, int pageNum);

    Data deleteOrder(String userId, String orderId);
}
