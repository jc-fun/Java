package com.jcfun.java;

import java.util.Objects;

/**
 * @ClassName: Person
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/7 下午10:44
 * @Version: 1.0.0
 * @Description: TODO
 */
@Deprecated
public class Person {

    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;

        if (!Objects.equals(name, person.name)) {
            return false;
        }
        return Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (age != null ? age.hashCode() : 0);
        return result;
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

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
