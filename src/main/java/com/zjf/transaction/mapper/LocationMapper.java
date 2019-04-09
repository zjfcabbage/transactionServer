package com.zjf.transaction.mapper;


import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LocationMapper {

    @Select("SELECT * FROM t_province")
    List<Province> getProvince();

    @Select("SELECT * FROM t_city WHERE id = #{provinceId}")
    List<City> getCityByProvinceId(@Param("id") int provinceId);

    @Select("SELECT * FROM t_university WHERE city_name = #{cityName}")
    List<University> getUniversityByCityName(@Param("city_name") String cityName);

}
