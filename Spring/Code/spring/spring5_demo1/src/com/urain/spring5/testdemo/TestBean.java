package com.urain.spring5.testdemo;

import com.urain.spring5.bean.Emp;
import com.urain.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: urain
 * @date: 2022/4/23 12:47
 * @description:
 * @version: 1.0
 */
public class TestBean {
    @Test
    public void testBean1() {
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        // 2.获取配置创建的对象
        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService);
        userService.add();
    }

    @Test
    public void testBean2() {
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        // 2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }

    @Test
    public void testBean3() {
        // 1.加载spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        // 2.获取配置创建的对象
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
        emp.add();
    }

}
