package com.urain.spring5.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: urain
 * @date: 2022/4/23 16:06
 * @description:
 * @version: 1.0
 */
public class Stu {
    // 数组类型属性
    private String[] courses;
    // List 集合类型属性
    private List<String> list;
    // Map集合类型属性
    private Map<String, String> map;
    // Set集合类型属性
    private Set <String> set;
    // 学生所学的课程
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void test() {
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(map);
        System.out.println(set);
        System.out.println(courseList);
    }
}
