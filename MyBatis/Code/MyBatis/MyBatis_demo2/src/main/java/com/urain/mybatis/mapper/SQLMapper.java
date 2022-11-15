package com.urain.mybatis.mapper;

import com.urain.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/4/29 17:33
 * @Description:
 * @Version: 1.0
 */

public interface SQLMapper {


    // 根据用户名模糊查询用户信息
    List<User> getUserByLike(@Param("username") String username);

    // 批量删除
    int deleteMore(@Param("ids") String ids);

    // 查询指定表中的数据
    List<User> getUserByTableName(@Param("tableName") String tableName);

    // 添加用户信息
    void insertUser(User user);


}
