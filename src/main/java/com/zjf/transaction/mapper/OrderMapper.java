package com.zjf.transaction.mapper;

import com.zjf.transaction.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {

    @Insert("insert into t_pay(order_id, user_id, timestamp, money) values(#{orderId},#{userId},#{timestamp},#{money})")
    void addOrder(@Param("orderId") String orderId,
                  @Param("userId") String userId,
                  @Param("timestamp") long timestamp,
                  @Param("money") String money);

    @Select("select order_id,user_id,timestamp,money from t_pay where user_id=#{userId}")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "contentList", column = "order_id",many = @Many(select = "com.zjf.transaction.mapper.OrderInfoMapper.getAll"))
    })
    List<Order> getOrder(@Param("userId") String userId);


    @Delete("delete from t_pay where order_id=#{orderId} and user_id=#{userId}")
    void deleteOrder(@Param("orderId")String orderId, @Param("userId")String userId);
}
