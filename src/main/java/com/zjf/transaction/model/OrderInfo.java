package com.zjf.transaction.model;

public class OrderInfo {
    private String orderId;
    private String userId;
    private String userName;
    private String userPicUrl;
    private String commodityId;
    private String imageUrl;
    private String msg;
    private String price;

    public OrderInfo(String orderId, String userId, String userName,
                     String userPicUrl, String commodityId, String imageUrl, String msg, String price) {
        this.orderId = orderId;
        this.userId = userId;
        this.userName = userName;
        this.userPicUrl = userPicUrl;
        this.commodityId = commodityId;
        this.imageUrl = imageUrl;
        this.msg = msg;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicUrl() {
        return userPicUrl;
    }

    public void setUserPicUrl(String userPicUrl) {
        this.userPicUrl = userPicUrl;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
