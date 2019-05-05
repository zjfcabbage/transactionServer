package com.zjf.transaction.controller;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping(value = "/image/simpleToken")
    public Data getSimpleToken() {
        return imageService.getSimpleToken();
    }

    @GetMapping(value = "/image/coverToken")
    public Data getCoverToken(String fileKey) {
        return imageService.getCoverToken(fileKey);
    }
}
