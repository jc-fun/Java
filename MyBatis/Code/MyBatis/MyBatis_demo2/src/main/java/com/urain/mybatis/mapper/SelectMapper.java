package com.urain.mybatis.mapper;

import com.urain.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Author: urain
 * @Date: 2022/4/29 16:43
 * @Description:
 * @Version: 1.0
 */

public interface SelectMapper {

    // 根据id查询用户信息
    List<User> getUserById(@Param("id") Integer id);

    // 查询所有的用户信息
    List<User> getAllUser();

    // 查询用户信息的总记录数
    Integer getCount();

    // 根据id查询用户信息为一个map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    // 查询所有用户信息为Map集合
    // List<Map<String, Object>> getAllUserToMap();
    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}
