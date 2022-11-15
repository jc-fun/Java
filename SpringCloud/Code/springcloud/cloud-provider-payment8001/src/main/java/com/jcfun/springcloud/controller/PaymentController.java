package com.jcfun.springcloud.controller;

import com.jcfun.springcloud.entities.CommonResult;
import com.jcfun.springcloud.entities.Payment;
import com.jcfun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: PaymentController
 * @Package: com.jcfun.springcloud.controller
 * @Author: jcfun
 * @Date: 2022/10/18 22:21
 * @Version: 1.0.0
 * @Description: TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据成功", result);
        } else {
            return CommonResult.builder().code(444).message("插入数据失败").build();
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommonResult<>(200, "查询数据成功", payment);
        } else {
            return new CommonResult<>(444, "没有查询到对应记录，查询ID: " + id);
        }
    }

}
