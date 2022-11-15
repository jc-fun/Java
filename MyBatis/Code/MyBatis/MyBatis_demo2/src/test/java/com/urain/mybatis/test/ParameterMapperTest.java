package com.urain.mybatis.test;

import com.urain.mybatis.mapper.ParameterMapper;
import com.urain.mybatis.pojo.User;
import com.urain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: urain
 * @Date: 2022/4/29 10:40
 * @Description:
 * @Version: 1.0
 */

public class ParameterMapperTest {

    /**
     * MyBatis获取参数值的两种方式
     * ${} 本质是字符串拼接
     * #{} 本质是占位符赋值
     * MyBatis获取参数值的各种情况
     *  1.mapper 接口方法的参数为单个字面量类型
     *      可以通过${}和#{}以任意的名称获取参数值，但是要注意${}的单引号问题
     *  2.mapper 接口方法的参数为多个时
     *      此时MyBatis会将这些参数放在一个Map集合中，以两种方式进行存储
     *          1）以arg0，arg1...为键，以参数为值
     *          2）以param0，param1...为键，以参数为值
     *      因此只需要通过#{}和${}以键的方式访问值即可，同样要注意${}的单引号问题
     *  3.mapper 接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     *      只需要通过#{}和${}以键的方式访问值即可，同样要注意${}的单引号问题
     *  4.mapper 接口方法的参数是一个实体类类型的参数
     *      只需要通过#{}和${}以属性的方式访问属性值即可，同样要注意${}的单引号问题
     *  5.使用@Param命名参数
     *      此时MyBatis会将这些参数放在一个Map集合中，以两种方式进行存储
     *          1）以@Param注解的值为键，以参数为值
     *          2）以param0，param1...为键，以参数为值
     *      因此只需要通过#{}和${}以键的方式访问值即可，同样要注意${}的单引号问题
     *
     */


    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }


    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Integer result = mapper.insertUser(new User(null, "李四", "123456", 23, "男", "email@email.com"));
        System.out.println(result);
    }


    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }


    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin", "123456");
        System.out.println(user);
    }


    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.getUserByUsername("admin");
        System.out.println(user);
    }


    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }
}
