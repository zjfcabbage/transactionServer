package com.zjf.transaction.service;

import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;

import java.util.List;

public interface LocationService {
    List<Province> getProvince();

    List<City> getCityByProvinceId(int provinceId);

    List<University> getUniversityByCityName(String cityName);
}
