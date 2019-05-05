package com.zjf.transaction.service;

import com.zjf.transaction.data.Data;

public interface ImageService {
    Data getSimpleToken();

    Data getCoverToken(String fileName);
}
