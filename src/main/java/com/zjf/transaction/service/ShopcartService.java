package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;

import java.util.List;

public interface ShopcartService {
    Data add(String userId, String commodityId);

    Data getShopcartItem(String userId, int pageNum);

    Data delete(String userId, String commodityId);

    Data deleteMore(String userId, List<String> commodityIdList);
}
