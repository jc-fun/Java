package com.urain.mybatis.mapper;

import com.urain.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/4/30 9:32
 * @Description:
 * @Version: 1.0
 */

public interface DynamicSQLMapper {

    // 多条件查询
    List<Emp> getEmpByCondition(Emp emp);

    // 测试choose、when、otherwise
    List<Emp> getEmpByChoose(Emp emp);

    // 通过数组实现批量删除
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    // 通过list集合实现批量添加
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
