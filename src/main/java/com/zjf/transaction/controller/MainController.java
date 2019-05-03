package com.zjf.transaction.controller;


import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;
import com.zjf.transaction.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping(value = "/upload")
    public Data uploadImages(@RequestParam(value = "id") String id, @RequestParam(value = "image") List<MultipartFile> files) {
        return mainService.uploadImages(id, files);
    }

    @GetMapping(value = "getAll")
    public Data getAll(@RequestParam(value = "pageNum") int pageNum) {
        return mainService.getAll(pageNum);
    }
}
