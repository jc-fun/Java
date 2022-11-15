package com.urain.springboot.boot.controller;

import com.urain.springboot.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: urain
 * @Date: 2022/5/7 22:08
 * @Description:
 * @Version: 1.0
 */
// @ResponseBody
// @Controller
//@JRebel
@Slf4j
@RestController
public class HelloController {

    @Resource
    Car car;

    @RequestMapping("/car")
    public Car car() {
        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {
        log.info("hello");
        return "Hello, Spring Boot2!";
    }

}
