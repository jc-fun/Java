package com.urain.springboot.boot.bean;

import lombok.*;

/**
 * @Author: urain
 * @Date: 2022/5/8 10:03
 * @Description:
 * @Version: 1.0
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;
    private Integer age;
    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
