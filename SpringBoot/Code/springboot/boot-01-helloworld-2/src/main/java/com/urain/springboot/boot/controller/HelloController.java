package com.urain.springboot.boot.controller;

import com.urain.springboot.boot.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: urain
 * @Date: 2022/5/8 21:21
 * @Description:
 * @Version: 1.0
 */
@RestController
public class HelloController {

    @Resource
    Person person;

    @RequestMapping("/person")
    public Person person() {
        return person;
    }

}
