package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;
import com.zjf.transaction.model.Commodity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MainService {
    Data publish(Commodity commodity);

    Data uploadImages(String id, List<MultipartFile> files);

    Data getAll(int pageNum);
}
