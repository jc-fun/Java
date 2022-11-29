package com.jcfun.java2;

import com.jcfun.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @ClassName: ReflectionTest
 * @Package: com.jcfun.java2
 * @Author: jcfun
 * @Date: 2022/11/29 下午5:12
 * @Version: 1.0.0
 * @Description: 调用运行时类中指定的结构
 */
public class ReflectionTest {

    @Test
    public void testFiled() throws Exception {
        Class<Person> clazz = Person.class;
        // 创建运行时类的对象
        Person person = clazz.getDeclaredConstructor().newInstance();

        // 获取指定的属性：要求运行时类中的属性声明为public
        // 通常不采用此方法
        Field id = clazz.getField("id");

        // 设置当前属性的值
        // set()：参数1：指明设置哪个对象的属性  参数2：将此属性值设置为多少
        id.set(person, 1001);

        // 获取当前属性值
        // get()：参数：获取哪个对象的属性值
        int pId = (int) id.get(person);
        System.out.println(pId);

    }

    @Test
    public void testField1() throws Exception {
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person person = clazz.getDeclaredConstructor().newInstance();

        // 获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "Tom");
        System.out.println(name.get(person));
    }


}
