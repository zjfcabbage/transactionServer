package com.zjf.transaction.mapper;

import com.zjf.transaction.Provider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShopcartMapper {

    @Insert("insert into t_shopcart(user_id, commodity_id) values(#{userId}, #{commodityId})")
    void add(@Param("userId") java.lang.String userId, @Param("commodityId") java.lang.String commodityId);

    @Select("select commodity_id from t_shopcart where user_id=#{userId}")
    List<java.lang.String> getAllShopcartItem(@Param("userId") java.lang.String userId);

    @Delete("delete from t_shopcart where user_id=#{userId} and commodity_id=#{commodityId}")
    void delete(@Param("userId") java.lang.String userId, @Param("commodityId") java.lang.String commodityId);

    @DeleteProvider(type = Provider.class, method = "batchDeleteShopcart")
    void deleteMore(@Param("userId") java.lang.String userId, @Param("list") List<String> commodityIdList);
}
