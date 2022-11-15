package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: urain
 * @date: 2022/4/27 9:53
 * @description:
 * @version: 1.0
 */

@Controller
public class UserController {
    /**
     * @author: urain
     * @date: 2022/4/27 9:55
     * @description: 使用RESTFul模拟用户资源的增删改查
     *              /user    GET    查询所有用户信息
     *              /user/1  GET    根据用户id查询用户信息
     *              /user    POST   添加用户信息
     *              /user/1  DELETE 删除用户信息
     *              /user    PUT    更新用户信息
     * @version: 1.0
    */

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getAllUser() {
        System.out.println("查询所有用户信息");
        return "success";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable String id) {
        System.out.println("根据用户id = " + id + "查询用户信息");
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String insertUser(String username, String password) {
        System.out.println("添加用户信息" + username + "," + password);
        return "success";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String updateUser(String username, String password) {
        System.out.println("修改用户信息" + username + "," + password);
        return "success";
    }

}
