package com.urain.springboot.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: urain
 * @Date: 2022/5/8 22:36
 * @Description:
 * @Version: 1.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser() {
        return "POST";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE";
    }



}
