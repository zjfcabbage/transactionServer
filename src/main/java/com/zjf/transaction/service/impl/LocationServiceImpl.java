package com.zjf.transaction.service.impl;

import com.zjf.transaction.mapper.LocationMapper;
import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;
import com.zjf.transaction.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "LocationService")
public class LocationServiceImpl implements LocationService {

    private LocationMapper locationMapper;

    @Override
    public List<Province> getProvince() {
        return locationMapper.getProvince();
    }

    @Override
    public List<City> getCityByProvinceId(int provinceId) {
        return locationMapper.getCityByProvinceId(provinceId);
    }

    @Override
    public List<University> getUniversityByCityName(String cityName) {
        return locationMapper.getUniversityByCityName(cityName);
    }
}
