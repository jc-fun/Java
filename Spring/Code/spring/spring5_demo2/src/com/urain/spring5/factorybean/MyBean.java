package com.urain.spring5.factorybean;

import com.urain.spring5.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: urain
 * @date: 2022/4/23 17:05
 * @description:
 * @version: 1.0
 */
public class MyBean implements FactoryBean<Course> {

    // 定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("abc");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
