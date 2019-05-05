package com.zjf.transaction.mapper;

import com.zjf.transaction.model.Commodity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MainMapper {

    @Insert("insert into t_commodity(id, user_id,image_url, msg, price, publish_time) values(#{id},#{userId},#{imageUrl},#{msg},#{price},#{publishTime})")
    void publish(@Param("id") String id,
                 @Param("userId") String userId,
                 @Param("imageUrl") String imageUrl,
                 @Param("msg") String msg,
                 @Param("price") String price,
                 @Param("publishTime") long publishTime);

    @Select("select * from t_commodity")
    List<Commodity> getAll();
}
