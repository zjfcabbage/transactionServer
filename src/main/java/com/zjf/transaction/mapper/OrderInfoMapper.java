package com.zjf.transaction.mapper;

import com.zjf.transaction.Provider;
import com.zjf.transaction.model.Order;
import com.zjf.transaction.model.OrderInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfoMapper {

    @Select("select * from t_order_info where order_id=#{orderId}")
    List<Order.Content> getAll(String orderId);

    @InsertProvider(type = Provider.class, method = "batchInsertOrderInfo")
    void addOrderInfo(@Param("list") List<OrderInfo> list);

    @Delete("delete from t_order_info where order_id=#{orderId}")
    void deleteOrderInfo(String orderId);
}
