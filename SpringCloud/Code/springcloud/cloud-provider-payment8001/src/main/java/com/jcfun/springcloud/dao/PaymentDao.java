package com.jcfun.springcloud.dao;

import com.jcfun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentDao
 * @Package: com.jcfun.springcloud.dao
 * @Author: jcfun
 * @Date: 2022/10/18 22:04
 * @Version: 1.0.0
 * @Description: TODO
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
