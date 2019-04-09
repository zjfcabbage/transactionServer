package com.zjf.transaction.mapper;


import com.zjf.transaction.model.City;
import com.zjf.transaction.model.Province;
import com.zjf.transaction.model.University;
import com.zjf.transaction.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ResponseBody
    @RequestMapping(value = "/province", produces = {"application/json;charset=UTF-8"})
    public List<Province> getProvince() {
        return locationService.getProvince();
    }

    @ResponseBody
    @RequestMapping(value = "/city", produces = {"application/json;charset=UTF-8"})
    public List<City> getCityByProvinceId(int provinceId) {
        return locationService.getCityByProvinceId(provinceId);
    }

    @ResponseBody
    @RequestMapping(value = "/university", produces = {"application/json;charset=UTF-8"})
    public List<University> getUniversitybyCityName(String cityName) {
        return locationService.getUniversityByCityName(cityName);
    }
}
