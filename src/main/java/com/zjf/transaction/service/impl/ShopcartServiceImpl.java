package com.zjf.transaction.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.mapper.MainMapper;
import com.zjf.transaction.mapper.ShopcartMapper;
import com.zjf.transaction.mapper.UserMapper;
import com.zjf.transaction.model.Commodity;
import com.zjf.transaction.model.ShopcartItem;
import com.zjf.transaction.model.User;
import com.zjf.transaction.service.ShopcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopcartServiceImpl implements ShopcartService {

    @Autowired
    private ShopcartMapper shopcartMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MainMapper mainMapper;

    @Override
    public Data add(String userId, String commodityId) {
        if (userId == null) {
            return ResponseUtil.error(0, "userId id null");
        } else if (commodityId == null) {
            return ResponseUtil.error(0, "commodityId is null");
        }
        shopcartMapper.add(userId, commodityId);
        return ResponseUtil.success();
    }

    @Override
    public Data getShopcartItem(String userId, int pageNum) {
        if (userId == null) {
            return ResponseUtil.error(0, "userId is null");
        }
        if (pageNum < 1) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, 10);
        List<String> shopcart = shopcartMapper.getAllShopcartItem(userId); //获取该用户购物车下所有的商品id
        List<ShopcartItem> shopcartItemList = new ArrayList<>();
        for (int i = 0; i < shopcart.size(); i++) {
            ShopcartItem item = new ShopcartItem();
            final String commodityId = shopcart.get(i);
            Commodity commodity = mainMapper.getCommodityById(commodityId); //根据商品id获取商品
            item.setCommodity(commodity);
            User user = userMapper.getUser(commodity.getUserId()); //根据该商品的所属用户id获取用户
            item.setUser(user);
            shopcartItemList.add(item);
        }
        return ResponseUtil.success(shopcartItemList);
    }

    @Override
    public Data delete(String userId, String commodityId) {
        if (userId == null) {
            return ResponseUtil.error(0, "userId is null");
        } else if (commodityId == null) {
            return ResponseUtil.error(0, "commodityId is null");
        }
        shopcartMapper.delete(userId, commodityId);
        return ResponseUtil.success();
    }

    @Override
    public Data deleteMore(String userId, List<String> commodityIdList) {
        if (userId == null || commodityIdList.isEmpty()) {
            return ResponseUtil.error(0, "userId or commodity list is null");
        }
        shopcartMapper.deleteMore(userId, commodityIdList);
        return ResponseUtil.success();
    }
}
