package com.urain.mybatis.test;

import com.urain.mybatis.mapper.EmpMapper;
import com.urain.mybatis.pojo.Emp;
import com.urain.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/4/30 13:49
 * @Description:
 * @Version: 1.0
 */

public class MBGTest {

    @Test
    public void testMBG() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            // 查询所有数据
            /*List<Emp> emps = mapper.selectByExample(null);
            emps.forEach(System.out::println);*/
            // 根据条件查询
            /*EmpExample example = new EmpExample();
            example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
            example.or().andDidIsNull();
            List<Emp> list = mapper.selectByExample(example);
            list.forEach(System.out::println);*/
            //mapper.updateByPrimaryKey(new Emp(1, "admin", 22, null, "456@qq.com", 3));
            mapper.updateByPrimaryKeySelective(new Emp(1, "admin", 22, null, "456@qq.com", 3));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
