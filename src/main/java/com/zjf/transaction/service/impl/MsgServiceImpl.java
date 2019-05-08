package com.zjf.transaction.service.impl;

import com.zjf.transaction.mapper.MsgMapper;
import com.zjf.transaction.model.Msg;
import com.zjf.transaction.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private MsgMapper msgMapper;

    @Override
    public List<Msg> getMsgByUserId(String toUserId) {
        return msgMapper.getMsgByUserId(toUserId);
    }

    @Override
    public void addToUserById(Msg msg) {
        if (msg == null) {
            return;
        }
        msgMapper.addToUserById(msg.getFromId(), msg.getToId(), msg.getMessage(), msg.getTimestamp());
    }

    @Override
    public void deleteMsgByUserId(String toUserId) {
        if (toUserId == null) {
            return;
        }
        msgMapper.deleteMsgByUserId(toUserId);
    }
}
