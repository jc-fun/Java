package com.jcfun.java1;

/**
 * @ClassName: Person
 * @Package: com.jcfun.java1
 * @Author: jcfun
 * @Date: 2022/11/29 上午10:16
 * @Version: 1.0.0
 * @Description: TODO
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person() {

    }

    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation) {
        System.out.println("我的国籍是：" + nation);
        return nation;
    }

    public String display(String interests, int year) throws NullPointerException, ClassCastException{
        return interests + ":" + age + "years";
    }


    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDest() {
        System.out.println("我是一个niubility的人");
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", id=" + id +
            ", weight=" + weight +
            '}';
    }
}
