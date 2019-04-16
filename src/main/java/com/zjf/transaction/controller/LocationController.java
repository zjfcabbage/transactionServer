package com.zjf.transaction.controller;


import com.zjf.transaction.data.Data;
import com.zjf.transaction.data.ResponseUtil;
import com.zjf.transaction.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @ResponseBody
    @RequestMapping("/province")
    public Data getProvince() {
        return ResponseUtil.success(locationService.getProvince());
    }

    @ResponseBody
    @RequestMapping("/city")
    public Data getCityByProvinceId(int provinceId) {
        return ResponseUtil.success(locationService.getCityByProvinceId(provinceId));
    }

    @ResponseBody
    @RequestMapping("/university")
    public Data getUniversityByCityId(int cityId) {
        return ResponseUtil.success(locationService.getUniversityByCityId(cityId));
    }
}
