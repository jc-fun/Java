package com.urain.spring5.testdemo;

import com.urain.spring5.config.SpringConfig;
import com.urain.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: urain
 * @date: 2022/4/23 22:08
 * @description:
 * @version: 1.0
 */
public class TestSpring5Demo1 {
    @Test
    public void testService1() throws ClassNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        UserService userService = context.getBean("userService", UserService.class);
//        System.out.println(UserService.class);
//        System.out.println(userService.getClass());
//        System.out.println(Class.forName("com.urain.spring5.service.UserService"));
        System.out.println(userService);
        userService.add();
    }


    @Test
    public void testService2() throws ClassNotFoundException {
        // 加载配置类
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
