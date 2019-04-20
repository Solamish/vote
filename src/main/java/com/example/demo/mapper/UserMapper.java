package com.example.demo.mapper;

import com.example.demo.bean.Voter;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {
    @Insert("Insert into user (uid,nickname,polls,pollstatus) value(#{uid}, #{nickname}, #{polls}, #{pollstatus}) ON DUPLICATE KEY UPDATE uid = #{uid}, polls = #{polls}, pollstatus = #{pollstatus}")
    void insertUser(@Param("uid") int uid, @Param("nickname") String nickname, @Param("polls") int polls, @Param("pollstatus") String pollstatus);

    @Select("Select * from user where uid = #{uid}")
    Voter findByUid(@Param("uid") int uid);

    @Update("Update user set polls = #{polls} where uid = #{uid}")
    void updatePoll(@Param("polls") int polls, @Param("uid") int uid);

    @Update("Update users set polls = 5, pollstatus = ''")
    void refreshPoll();
}
