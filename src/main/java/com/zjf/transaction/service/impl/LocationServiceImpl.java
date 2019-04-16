package com.zjf.transaction.service.impl;

import com.zjf.transaction.mapper.LocationMapper;
import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;
import com.zjf.transaction.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
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
    public List<University> getUniversityByCityId(int cityId) {
        return locationMapper.getUniversityByCityId(cityId);
    }
}
