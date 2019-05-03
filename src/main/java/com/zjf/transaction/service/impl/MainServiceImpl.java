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
    private static final String COMMODITY_PIC_URL = "http://47.100.61.176:8080/image/";

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
    public Data uploadImages(String id, List<MultipartFile> files) {
        if (id == null || files.isEmpty()) {
            return ResponseUtil.error(0, "参数错误");
        }
        String[] strings = id.split("--");
        String userId = "";
        if (strings.length > 0) {
            userId = strings[0];
        }
        StringJoiner imageUrlJoiner = new StringJoiner("@@@"); //以@@@做url的分隔符

        File parent = new File(ROOT_DIR + userId + File.separator + id);
        if (!parent.exists()) {
            parent.mkdirs();
        }
        int i= 0;
        for (; i < files.size(); i++) {
            String fileName = files.get(i).getOriginalFilename();
            try {
                files.get(i).transferTo(new File(parent, fileName));
                imageUrlJoiner.add(COMMODITY_PIC_URL + userId + File.separator + id + File.separator +fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (i == files.size()) {
            mainMapper.updateImageUrl(imageUrlJoiner.toString(), id);
            LoggerFactory.getLogger(getClass().getName()).debug(imageUrlJoiner.toString());
            return ResponseUtil.success();
        } else {
            return ResponseUtil.error(0, "文件传输出错");
        }
    }

    @Override
    public Data getAll(int pageNum) {
        PageHelper.startPage(pageNum, 20);
        return ResponseUtil.success(mainMapper.getAll());
    }
}
