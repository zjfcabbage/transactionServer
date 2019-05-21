package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;

import java.util.List;

public interface MainService {
    Data publish(Commodity commodity);

    Data getAll(int pageNum);

    Data getCommodityById(String id);

    Data getByName(String name, int pageNum);

    Data delete(List<String> list);

    Data markCommodityIsSold(List<String> list);
}