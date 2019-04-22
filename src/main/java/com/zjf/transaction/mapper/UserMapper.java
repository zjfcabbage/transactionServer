package com.zjf.transaction.mapper;

import com.zjf.transaction.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

    @Select("SELECT * from t_user where user_id=#{userId}")
    User getUser(@Param("userId") String userId);

    @Insert("insert into t_user(user_id, user_name, password, user_pic, province, city, university)" +
            "values(#{userId}, #{userName}, #{password}, #{userPicUrl}, " +
            "#{province}, #{city}, #{university})")
    void registerUser(@Param("userId") String userId, @Param("userName") String userName,
                      @Param("password") String password, @Param("userPicUrl") String userPicUrl,
                      @Param("province") String province, @Param("city") String city,
                      @Param("university") String university);

    @Update("update t_user set password= #{password} where user_id=#{userId}")
    void updateUserPassword(@Param("password") String password, @Param("userId") String userId);

    @Update("update t_user set user_name=#{userName} where user_id=#{userId}")
    void updateUserName(@Param("userName") String userName, @Param("userId") String userId);

    @Select("select * from t_user where user_name=#{userName} and password=#{password}")
    User login(@Param("userName") String userName, @Param("password") String password);

    @Select("select * from t_user where user_name=#{userName}")
    User isUserNameExisted(@Param("userName") String userName);
}
