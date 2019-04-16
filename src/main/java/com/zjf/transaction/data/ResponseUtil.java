package com.zjf.transaction.data;

public class ResponseUtil {
    public static Data success(Object s) {
        Data data = new Data();
        data.setCode(1);
        data.setMsg("success");
        data.setData(s);
        return data;
    }
    public static Data success() {
        Data data = new Data();
        data.setCode(1);
        data.setMsg("success");
        return data;
    }

    public static Data error(int code, String msg) {
        Data data = new Data();
        data.setCode(code);
        data.setMsg(msg);
        data.setData(null);
        return data;
    }
}
