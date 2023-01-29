package com.example.mybatisspringboot;

import com.example.mybatisspringboot.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from users")
    List<User> findUsers();

    @Select("select * from users where id = #{id}")
    User findUserById(Integer id);

    @Update("update users set address = #{user.address} where id = #{id}")
    void updateUserAddressById(User user, int id);

}