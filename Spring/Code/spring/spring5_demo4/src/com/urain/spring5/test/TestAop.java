package com.urain.spring5.test;

import com.urain.spring5.aopanno.User;
import com.urain.spring5.aopxml.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: urain
 * @date: 2022/4/24 14:57
 * @description:
 * @version: 1.0
 */
public class TestAop {
    @Test
    public void testAopAnno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();

    }

    @Test
    public void testAopXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        book.buy();

    }
}
