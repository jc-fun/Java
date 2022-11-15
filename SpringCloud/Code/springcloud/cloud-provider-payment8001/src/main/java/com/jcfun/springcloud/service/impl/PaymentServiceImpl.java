package com.jcfun.springcloud.service.impl;

import com.jcfun.springcloud.dao.PaymentDao;
import com.jcfun.springcloud.entities.Payment;
import com.jcfun.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentServiceImpl
 * @Package: com.jcfun.springcloud.service.impl
 * @Author: jcfun
 * @Date: 2022/10/18 22:18
 * @Version: 1.0.0
 * @Description: TODO
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
