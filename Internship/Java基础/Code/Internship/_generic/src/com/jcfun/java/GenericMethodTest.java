package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenericMethodTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/18 上午10:40
 * @Version: 1.0.0
 * @Description: TODO
 */
public class GenericMethodTest {

    @Test
    public void test() {
        Person<String> person = new Person<>();
        String[] strings = {"123", "hello"};
        List<String> strings1 = person.copyFromArrayToList(strings);
        System.out.println(strings1);
    }

}

class Person<T> {
    private String name;
    private Integer age;

    private T date;

    public Person(String name, Integer age, T date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public <E, C> List<C> copyFromArrayToList(E[] arr) {
        ArrayList<C> list = new ArrayList<>();
        for (E e : arr) {
            list.add((C) e);
        }
        return list;
    }

}
