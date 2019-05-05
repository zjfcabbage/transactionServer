package com.zjf.transaction.controller;


import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;
import com.zjf.transaction.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "getAll")
    public Data getAll(@RequestParam(value = "pageNum") int pageNum) {
        return mainService.getAll(pageNum);
    }
}
