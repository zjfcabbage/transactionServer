package com.zjf.transaction.mapper.user.location;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LocationMapper {


    @Select("SELECT * FROM province")
    String getProvince();

    @Select("SELECT * FROM city WHERE province = #{province}")
    String getCity(@Param("province") String province);

    @Select("SELECT * FROM university WHERE city = #{city}")
    String getUniversity(@Param("city") String city);

}
