package com.zjf.transaction.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopcartMapper {

    @Insert("insert into t_shopcart(user_id, commodity_id) values(#{userId}, #{commodityId})")
    void add(@Param("userId") String userId, @Param("commodityId") String commodityId);

    @Select("select commodity_id from t_shopcart where user_id=#{userId}")
    List<String> getAllShopcartItem(@Param("userId") String userId);

    @Delete("delete from t_shopcart where user_id=#{userId} and commodity_id=#{commodityId}")
    void delete(String userId, String commodityId);
}
