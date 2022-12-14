package com.urain.mybatis.test;

import com.urain.mybatis.mapper.DeptMapper;
import com.urain.mybatis.mapper.EmpMapper;
import com.urain.mybatis.pojo.Dept;
import com.urain.mybatis.pojo.Emp;
import com.urain.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/4/29 21:18
 * @Description:
 * @Version: 1.0
 */

public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况
     *  1.为字段起别名，保持和属性名一致
     *  2.设置全局配置，将下划线自动映射为驼峰
     *      <setting name="mapUnderscoreToCamelCase" value="true"/>
     *  3.通过resultMap设置自定义的映射关系
     *      <resultMap id="empResultMap" type="Emp">
     *         <id property="eid" column="eid"/>
     *         <result property="empName" column="emp_name"/>
     *         <result property="age" column="age"/>
     *         <result property="sex" column="sex"/>
     *         <result property="email" column="email"/>
     *     </resultMap>
     *
     * 处理多对一的映射关系
     *  1.级联属性赋值
     *  2.association
     *  3.分步查询
     *
     * 处理一对多的映射关系
     *  1.collection
     *  2.分步查询
     *
     */

    @Test
    public void testGetEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println(emp.getDept());
    }

    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(3);
        System.out.println(emp);
    }

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(System.out::println);

    }

    @Test
    public void testGetDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        // System.out.println(dept);
        System.out.println(dept.getDeptName());
    }

}
