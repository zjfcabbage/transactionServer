package com.zjf.transaction.service.impl;

import com.github.pagehelper.PageHelper;
import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.mapper.MainMapper;
import com.zjf.transaction.model.Commodity;
import com.zjf.transaction.service.MainService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainServiceImpl implements MainService {
    
    @Autowired
    private MainMapper mainMapper;

    @Override
    public Data publish(Commodity commodity) {
        if (commodity == null) {
            return ResponseUtil.error(0, "参数错误");
        }
        LoggerFactory.getLogger(getClass().getName()).debug(commodity.toString());
        mainMapper.publish(commodity.getId(),
                commodity.getUserId(),
                commodity.getName(),
                commodity.getImageUrl(),
                commodity.getMsg(),
                commodity.getPrice(),
                commodity.getPublishTime());
        return ResponseUtil.success();
    }

    @Override
    public Data getAll(int pageNum) {
        PageHelper.startPage(pageNum, 20);
        return ResponseUtil.success(mainMapper.getAll());
    }

    @Override
    public Data getCommodityById(String id) {
        if (id == null) {
            return ResponseUtil.error(0, "id is null");
        } else {
            return ResponseUtil.success(mainMapper.getCommodityById(id));
        }
    }

    @Override
    public Data delete(List<String> list) {
        if (list.isEmpty()) {
            return ResponseUtil.error(0, "commodity id list is null or empty");
        }
        mainMapper.deleteCommodity(list);
        return ResponseUtil.success();
    }

    @Override
    public Data markCommodityIsSold(List<String> list) {
        if (list.isEmpty()) {
            return ResponseUtil.error(0, "参数为空");
        }
        mainMapper.markCommodityIsSold(list);
        return ResponseUtil.success();
    }
}
