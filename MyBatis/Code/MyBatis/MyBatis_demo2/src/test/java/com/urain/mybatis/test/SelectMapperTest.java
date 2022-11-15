package com.urain.mybatis.test;

import com.urain.mybatis.mapper.SelectMapper;
import com.urain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Author: urain
 * @Date: 2022/4/29 16:54
 * @Description:
 * @Version: 1.0
 */

public class SelectMapperTest {


    /**
     * MyBatis的各种查询功能：
     *  1.若查询出的数据只有一条
     *      1）通过实体类对象接收
     *      2）通过List集合接收
     *      3）通过Map集合接收：{password=123456, sex=男, id=3, age=23, email=123456@qq.com, username=admin}
     *  2.若查询出的数据有多条
     *      1）通过实体类类型的List集合接收
     *      2）通过Map类型的List集合接收
     *      3）可以在mapper接口的方法上添加@MapKey注解，此时就可以将每条数据转换的map集合作为值，以某一个字段作为键，放在同一个Map集合中
     *
     *  注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     *  MyBatis中设置了默认的类型别名
     *  java.lang.Integer --> int, integer
     *  int --> _int, _integer
     *  Map --> map
     *  String --> string
     */


    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUserToMap());
    }


    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserByIdToMap(3));
    }


    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }


    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getAllUser());
    }


    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getUserById(3));
    }


}
