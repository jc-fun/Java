package com.urain.spring5.testdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.urain.spring5.autowire.Emp;
import com.urain.spring5.bean.Orders;
import com.urain.spring5.collectiontype.Book;
import com.urain.spring5.collectiontype.Course;
import com.urain.spring5.collectiontype.Stu;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: urain
 * @date: 2022/4/23 16:19
 * @description:
 * @version: 1.0
 */
public class TestSpring5Demo1 {
    @Test
    public void testCollection1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.test();
    }

    @Test
    public void testCollection2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book1 = context.getBean("book", Book.class);
        Book book2 = context.getBean("book", Book.class);
        //book.test();
        System.out.println(book1);
        System.out.println(book2);
    }

    @Test
    public void testFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testBean() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步，获取创建的bean实例对象");
        System.out.println(orders);
        // 手动销毁bean实例
        context.close();
    }

    @Test
    public void testAutoWire() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }

    @Test
    public void testJdbc() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        DruidDataSource dataSource = context.getBean("dataSource", DruidDataSource.class);
        System.out.println(dataSource);
    }

}
