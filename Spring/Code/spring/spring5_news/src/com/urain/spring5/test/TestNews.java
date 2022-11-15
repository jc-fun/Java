package com.urain.spring5.test;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author: urain
 * @date: 2022/4/24 17:58
 * @description:
 * @version: 1.0
 */

public class TestNews {
    // 函数式风格创建对象，交给spring进行管理
    @Test
    public void testGenericApplicationContext() {
        // 1.创建GenericApplicationContext对象
        GenericApplicationContext context = new GenericApplicationContext();
        // 2.调用context的refresh方法进行对象的注册
        context.refresh();
        context.registerBean(User.class, () -> new User()); // 不指定对象名称
        context.registerBean("user1", User.class, () -> new User()); // 指定对象名称
        // 3.获取在spring注册的对象
        User user = (User)context.getBean("com.urain.spring5.test.User");
        User user1 = (User)context.getBean("user1");
        System.out.println(user);
        System.out.println(user1);
    }


}
