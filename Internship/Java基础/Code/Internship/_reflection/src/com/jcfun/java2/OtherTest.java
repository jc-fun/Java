package com.jcfun.java2;

import com.jcfun.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName: OtherTest
 * @Package: com.jcfun.java2
 * @Author: jcfun
 * @Date: 2022/11/29 下午4:25
 * @Version: 1.0.0
 * @Description: TODO
 */
public class OtherTest {

    // 获取构造器结构
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        // 获取当前运行时类中声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor :
            constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        // 获取当前运行时类中声明所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

    }

    // 获取运行时类的父类
    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    // 获取运行时类的带泛型的父类
    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    // 获取运行时类的带泛型的父类的泛型
    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        // 获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        // System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class<?>) actualTypeArguments[0]).getName());

    }

    // 获取运行时类实现的接口
    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        System.out.println();

        // 获取运行时类的父类实现的接口
        Class<?>[] superInterfaces = clazz.getSuperclass().getInterfaces();
        for (Class<?> i : superInterfaces) {
            System.out.println(i);
        }
    }

    // 获取运行时类所在的包
    @Test
    public void test6() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    // 获取运行时类声明的注解
    @Test
    public void test7() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation  annotation : annotations) {
            System.out.println(annotation);
            System.out.println(annotation.annotationType().getName());
        }
    }


}
