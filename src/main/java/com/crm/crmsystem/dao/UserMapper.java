package com.crm.crmsystem.dao;

import com.crm.crmsystem.dao.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //根据用户名查询用户
    User selectUserByUsername(@Param("username") String username);

    //更新用户信息
    int updateById(User user);

    //用户失效
    int deleteByIsValid(Integer id);

    //分页查询
    List<User> selectUsers(@Param("form") User user);
}