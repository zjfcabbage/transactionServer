package com.zjf.transaction.mapper;

import com.zjf.transaction.Provider;
import com.zjf.transaction.model.Commodity;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MainMapper {

    @Insert("insert into t_commodity(id, user_id, name, image_url, msg, price, publish_time) values(#{id},#{userId},#{name},#{imageUrl},#{msg},#{price},#{publishTime})")
    void publish(@Param("id") String id,
                 @Param("userId") String userId,
                 @Param("name") String name,
                 @Param("imageUrl") String imageUrl,
                 @Param("msg") String msg,
                 @Param("price") String price,
                 @Param("publishTime") long publishTime);

    @Select("select * from t_commodity")
    List<Commodity> getAll();

    @Select("select * from t_commodity where id=#{id}")
    Commodity getCommodityById(@Param("id") String id);

    @DeleteProvider(type = Provider.class, method = "batchDeleteMain")
    void deleteCommodity(@Param("list") List<String> commodityIdList);
}
