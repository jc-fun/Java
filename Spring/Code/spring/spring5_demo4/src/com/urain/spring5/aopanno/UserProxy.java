package com.urain.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: urain
 * @date: 2022/4/24 14:42
 * @description:
 * @version: 1.0
 */

// 增强的类
@Component
@Aspect // 生成代理对象
@Order(3)
public class UserProxy {

    // 相同切入点抽取
    @Pointcut("execution(* com.urain.spring5.aopanno.User.add(..))")
    public void pointDemo() {

    }

    // 前置通知
    // @Before注解表示作为前置通知
    @Before(value = "pointDemo()")
    public void before() {
        System.out.println("before......");
    }

    // @After最终通知
    @After(value = "execution(* com.urain.spring5.aopanno.User.add(..))")
    public void after() {
        System.out.println("after......");
    }

    // @AfterReturning后置通知(返回通知)
    @AfterReturning(value = "execution(* com.urain.spring5.aopanno.User.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning......");
    }

    // @AfterThrowing异常通知
    @AfterThrowing(value = "execution(* com.urain.spring5.aopanno.User.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing......");
    }

    // @Around环绕通知
    @Around(value = "execution(* com.urain.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前......");
        // 被增强的方法执行
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后......");
    }
}
