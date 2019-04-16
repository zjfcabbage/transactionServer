package com.zjf.transaction.mapper;


import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {

    @Select("SELECT * FROM t_province")
    List<Province> getProvince();

    @Select("SELECT * FROM t_city WHERE province_id = #{provinceId}")
    List<City> getCityByProvinceId(@Param("provinceId") int provinceId);

    @Select("SELECT * FROM t_university WHERE city_id = #{cityId}")
    List<University> getUniversityByCityId(@Param("cityId") int cityId);

}
