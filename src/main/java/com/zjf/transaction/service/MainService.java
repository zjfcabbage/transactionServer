package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;

public interface MainService {
    Data publish(Commodity commodity);

    Data getAll(int pageNum);

    Data getCommodityById(String id);
}