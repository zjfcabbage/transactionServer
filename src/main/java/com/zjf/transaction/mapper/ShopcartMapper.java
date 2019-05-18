package com.zjf.transaction.mapper;

import com.zjf.transaction.Provider;
import com.zjf.transaction.model.ShopcartItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopcartMapper {

    @Insert("insert into t_shopcart(user_id, commodity_id) values(#{userId}, #{commodityId})")
    void add(@Param("userId") String userId, @Param("commodityId") String commodityId);

    @Select("select commodity_id from t_shopcart where user_id=#{userId}")
    List<String> getAllShopcartItem(@Param("userId") String userId);

    @Delete("delete from t_shopcart where user_id=#{userId} and commodity_id=#{commodityId}")
    void delete(@Param("userId") String userId, @Param("commodityId") String commodityId);

    @DeleteProvider(type = Provider.class, method = "batchDeleteShopcart")
    void deleteMore(@Param("userId") String userId, @Param("list") List<String> commodityIdList);

    @Select("select count(*) from t_shopcart where user_id=#{userId} and commodity_id=#{commodityId}")
    int isShopcartExist(@Param("userId") String userId, @Param("commodityId") String commodityId);
}
