package com.zjf.transaction.mapper;

import com.zjf.transaction.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("SELECT * from t_userinfo where user_id = #'{userId}'")
    User getUser(@Param("userId") String userId);

    @Insert("insert into t_userinfo(user_id, user_name, password, user_pic, province, city, university)" +
            "values(#'{userId}', #'{userName}', #'{password}', #'{userPicUrl}')," +
            "#'{province}', #'{city}', #'{university}'")
    void addUser(@Param("user") User user);

    @Update("update t_userinfo set password= #'{password}' where user_id=#'{userId}'")
    void updateUserPassword(@Param("password") String password, @Param("userId") String userId);
}
