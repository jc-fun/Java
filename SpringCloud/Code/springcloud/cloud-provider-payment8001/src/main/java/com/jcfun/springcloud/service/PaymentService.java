package com.jcfun.springcloud.service;

import com.jcfun.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: PaymentService
 * @Package: com.jcfun.springcloud.service
 * @Author: jcfun
 * @Date: 2022/10/18 22:17
 * @Version: 1.0.0
 * @Description: TODO
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);


}
