package com.jcfun.java;

/**
 * @ClassName: SignalTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/16 上午9:20
 * @Version: 1.0.0
 * @Description: 线程安全的单例模式：改写懒汉式为线程安全的形式
 */
public class SignalTest {

    private static Person person = null;

    public static Person getPerson() {
        if (person == null) {
            synchronized (Person.class) {
                person = new Person();
            }
        }
        return person;
    }
}


class Person {

}