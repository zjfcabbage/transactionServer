package com.zjf.transaction.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.mapper.OrderInfoMapper;
import com.zjf.transaction.mapper.OrderMapper;
import com.zjf.transaction.model.Order;
import com.zjf.transaction.model.OrderInfo;
import com.zjf.transaction.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    @Transactional
    public Data addOrder(Order order) {
        if (order == null) {
            return ResponseUtil.error(0, "参数为空");
        }
        List<Order.Content> orderItemList = order.getContentList();
        List<OrderInfo> orderInfoList = new ArrayList<>();
        for (Order.Content content : orderItemList) {
            orderInfoList.add(new OrderInfo(
                    order.getOrderId(),
                    content.getUserId(),
                    content.getUserName(),
                    content.getUserPicUrl(),
                    content.getCommodityId(),
                    content.getImageUrl(),
                    content.getMsg(),
                    content.getPrice()));
        }
        orderMapper.addOrder(order.getOrderId(), order.getUserId(),order.getTimestamp(),order.getMoney());
        orderInfoMapper.addOrderInfo(orderInfoList);
        return ResponseUtil.success();
    }

    @Override
    public Data getOrder(String userId, int pageNum) {
        if (userId == null) {
            return ResponseUtil.error(0, "参数为空");
        }
        PageHelper.startPage(pageNum, 10);
        return ResponseUtil.success(orderMapper.getOrder(userId));
    }

    @Transactional
    @Override
    public Data deleteOrder(String userId, String orderId) {
        if (userId == null || orderId == null) {
            return ResponseUtil.error(0, "参数为空");
        }
        orderMapper.deleteOrder(orderId, userId);
        orderInfoMapper.deleteOrderInfo(orderId);
        return ResponseUtil.success();
    }
}
