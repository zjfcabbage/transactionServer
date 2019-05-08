package com.zjf.transaction.service;

import com.zjf.transaction.model.Msg;

import java.util.List;

public interface MsgService {

    List<Msg> getMsgByUserId(String toUserId);

    void addToUserById(Msg msg);

    void deleteMsgByUserId(String tuUserId);
}
