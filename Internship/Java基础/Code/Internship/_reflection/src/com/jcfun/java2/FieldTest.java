package com.jcfun.java2;

import com.jcfun.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @ClassName: FieldTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/29 上午10:29
 * @Version: 1.0.0
 * @Description: TODO
 */
public class FieldTest {

    @Test
    public void test1() {
        Class<Person> clazz = Person.class;

        // 获取属性结构
        // 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f :
            fields) {
            System.out.println(f);
        }

        System.out.println();

        // 获取当前运行时类中声明的所有属性（不包含父类中的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f :
            declaredFields) {
            System.out.println(f);
        }
    }

    // 权限修饰符、数据类型、变量名
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f :
            declaredFields) {
            // 1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");

            // 2.数据类型
            Class<?> type = f.getType();
            System.out.print(type.getName() + "\t");

            // 3.变量名
            String fName = f.getName();
            System.out.print(fName);

            System.out.println();

        }
    }



}
