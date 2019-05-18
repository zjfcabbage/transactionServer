package com.zjf.transaction.controller;


import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;
import com.zjf.transaction.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private MainService mainService;

    @ResponseBody
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public Data publish(@RequestBody Commodity commodity) {
        return mainService.publish(commodity);
    }

    @GetMapping(value = "/getAll")
    public Data getAll(@RequestParam(value = "pageNum") int pageNum) {
        return mainService.getAll(pageNum);
    }

    @GetMapping(value = "/getCommodityById")
    public Data getCommodityById(String id) {
        return mainService.getCommodityById(id);
    }

    @DeleteMapping(value = "/delete")
    public Data delete(@RequestBody List<String> list) {
        return mainService.delete(list);
    }

    @PostMapping(value = "/mark")
    public Data markCommodityIsSold(@RequestBody List<String> list) {
        return mainService.markCommodityIsSold(list);
    }
}
