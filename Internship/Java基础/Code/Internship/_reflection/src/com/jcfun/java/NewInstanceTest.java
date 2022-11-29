package com.jcfun.java;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

/**
 * @ClassName: NewInstanceTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/29 上午9:04
 * @Version: 1.0.0
 * @Description: TODO
 */
public class NewInstanceTest {

    @Test
    public void test1() throws Exception {
        Class<Person> personClass = Person.class;

        // newInstance
        Person person = personClass.newInstance();
        System.out.println(person);

    }


    // 反射的动态性
    @Test
    public void test2() {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2 :
                classPath = "com.jcfun.java.Person";
                break;
        }
        try {
            Object instance = getInstance(classPath);
            System.out.println("instance = " + instance);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    // 创建指定类的对象
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }


}
