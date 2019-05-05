package com.zjf.transaction.util;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class QiNiuUtil {
    private static final String accessKey = "aH881J-YZJPRTR_7-79G5DjPuxWVHStbtf9_Lywo";
    private static final String secretKey = "atTX13WZUI_PohkUmT0oikJpeWDOpaXtsBdUiUYU";
    private static final String BUCKET = "transaction";


    /**
     * 简单上传的token
     * @return
     */
    public static String getSimpleToken(){
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(BUCKET);
    }

    /**
     * 覆盖上传的token
     * @param fileKey 进行覆盖的文件名称
     * @return
     */
    public static String getCoverToken(String fileKey) {
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(BUCKET, fileKey, 3600L, new StringMap().put("insertOnly", 0));
    }
}

