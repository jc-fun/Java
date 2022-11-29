package com.jcfun.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: ReflectionTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/28 上午11:02
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ReflectionTest {

    // 反射之前，对于Person的操作
    @Test
    public void test1() {

        // 1.创建Person类的对象
        Person p1 = new Person("Tom", 12);

        // 2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1);
        p1.show();

        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构
        // 比如：name、showNation()以及私有的构造器

    }

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        // 通过反射，创建Person类的对象
        Class<Person> aClass = Person.class;
        Constructor<Person> constructor = aClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Tom", 12);
        System.out.println(person);

        // 通过反射，调用对象指定的属性、方法
        Field age = aClass.getDeclaredField("age");
        age.set(person, 15);
        System.out.println(person);

        // 调用方法
        Method show = aClass.getDeclaredMethod("show");
        show.invoke(person);
        System.out.println(person);

        // 通过反射，可以调用Person类的私有结构。比如：私有的构造器、方法、属性
        // 调用私有构造器
        Constructor<Person> constructor1 = aClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Person person1 = constructor1.newInstance("Jerry");
        System.out.println(person1);

        // 调用私有属性
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Jane");
        System.out.println(person1);

        // 调用私有方法
        Method showNation = aClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(person1, "中国");
        System.out.println(nation);

    }


    // 获取Class实例的方式
    @Test
    public void test3() throws Exception {
        // 方式一：调用运行时类的属性
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        // 方式二：通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> clazz1 = person.getClass();
        System.out.println(clazz1);

        // 方式三：调用Class的静态方法：forName(String classpath)
        Class<?> clazz2 = Class.forName("com.jcfun.java.Person");
        System.out.println(clazz2);

        System.out.println(clazz == clazz1);
        System.out.println(clazz1 == clazz2);

        // 方式四：使用类的加载器：ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz3 = classLoader.loadClass("com.jcfun.java.Person");
        System.out.println(clazz3 == clazz);

    }


}
