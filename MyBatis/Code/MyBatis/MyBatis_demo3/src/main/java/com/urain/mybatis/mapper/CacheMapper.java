package com.urain.mybatis.mapper;

import com.urain.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: urain
 * @Date: 2022/4/30 11:24
 * @Description:
 * @Version: 1.0
 */

public interface CacheMapper {

    Emp getEmpByEid(@Param("eid") Integer eid);

    void insertEmp(Emp emp);


}
