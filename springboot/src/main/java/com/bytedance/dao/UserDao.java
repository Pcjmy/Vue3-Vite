package com.bytedance.dao;

import com.bytedance.controller.DTO.UserQueryDTO;
import com.bytedance.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> findAll();

    User getById(Integer id);

    User getByUser(@Param("username") String username, @Param("password") String password);

    int insert(User user);

    int update(User user);

    int deleteById(Integer id);

    List<User> findPage(UserQueryDTO userQueryDTO);

    long count(UserQueryDTO userQueryDTO);

    List<User> findByOptions(UserQueryDTO userQueryDTO);

}
