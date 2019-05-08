package com.zjf.transaction.mapper;

import com.zjf.transaction.model.Msg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MsgMapper {

    //获取此用户不在线时，其他用户发送过来的消息
    @Select("select * from t_msg where to_id=#{toUserId}")
    List<Msg> getMsgByUserId(@Param("toUserId") String toUserId);

    //发送给toUserId用户的消息因用户不在线，所在暂存到数据库中
    @Insert("insert into t_msg(from_id, to_id, message, timestamp) values(#{fromId}, #{toId}, #{message}, #{timestamp})")
    void addToUserById(@Param("fromId") String fromId,
                       @Param("toId")String toId,
                       @Param("message")String message,
                       @Param("timestamp")long timestamp);

    //当数据库存储的消息已发送给这个用户之后，将发送给这个用户的消息全部删除
    @Delete("delete from t_msg where to_id=#{toUserId}")
    void deleteMsgByUserId(String toUserId);
}
