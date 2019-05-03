package com.zjf.transaction.model;

public class Commodity {
    private String id;
    private String userId;
    private String imageUrl;
    private String msg;
    private float price;
    private long publishTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id='" + id + '\'' +
                ", msg='" + msg + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", userId='" + userId + '\'' +
                ", publishTime=" + publishTime +
                '}';
    }
}
