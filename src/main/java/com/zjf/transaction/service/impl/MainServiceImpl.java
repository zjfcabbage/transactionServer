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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

@Service
public class MainServiceImpl implements MainService {

    private static final String ROOT_DIR = "/home/transaction/image/";
//    private static final String ROOT_DIR = "d:\\test\\";

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


}