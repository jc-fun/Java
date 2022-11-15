package com.urain.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: urain
 * @date: 2022/4/24 15:51
 * @description:
 * @version: 1.0
 */

@Component
@Aspect
@Order(1)
public class PersonProxy {
    @Before("execution(* com.urain.spring5.aopanno.User.add(..))")
    public void before() {
        System.out.println("Person Before......");
    }
}
