package com.example.demo.mapper;

import com.example.demo.bean.Cheerleader;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface CheerleaderMapper {

    @Insert("Insert into cheerleader (id,college,polls) value(#{id},#{college},#{polls}) ON DUPLICATE KEY UPDATE polls = #{polls+1}")
    void insertCheerleader(@Param("college") String college, @Param("polls") int polls, @Param("id") int id);

    @Select("Select polls from cheerleader where id = #{id}")
    int findPolls(@Param("id") int id);

    @Update("Update cheerleader set polls = #{polls} where id = #{id}")
    void updateCheerleader(@Param("polls") int polls, @Param("id") int id);

    @Delete("Delete from cheerleader where id = #{id}")
    void deleteById(@Param("id") int id);
}
