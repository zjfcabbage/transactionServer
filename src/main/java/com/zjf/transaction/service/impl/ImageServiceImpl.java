package com.zjf.transaction.service.impl;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.service.ImageService;
import com.zjf.transaction.util.QiNiuUtil;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Data getSimpleToken() {
        return ResponseUtil.success(QiNiuUtil.getSimpleToken());
    }

    @Override
    public Data getCoverToken(String fileName) {
        return ResponseUtil.success(QiNiuUtil.getCoverToken(fileName));
    }
}
