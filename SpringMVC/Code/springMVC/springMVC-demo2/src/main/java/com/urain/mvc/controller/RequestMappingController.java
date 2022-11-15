package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: urain
 * @date: 2022/4/26 0:16
 * @description:
 * @version: 1.0
 */

@Controller
//@RequestMapping("/hello")
public class RequestMappingController {

    @RequestMapping(
        value = {"/testRequestMapping", "/test"},
        method = {RequestMethod.GET, RequestMethod.POST}
    )
    public String success() {
        return "success";
    }

    @GetMapping("/testGetMapping")
    public String testGetMapping() {
        return "success";
    }

    @RequestMapping(value = "testPut", method = RequestMethod.PUT)
    public String testPut() {
        return "success";
    }

    @RequestMapping(
        value = "/testParamsAndHeaders",
        params = {"username", "password!=123"},
        headers = {"Host=localhost:8080"}
    )
    public String testParamsAndHeaders() {
        return "success";
    }

    //@RequestMapping("/a?a/testAnt")
    //@RequestMapping("/a*a/testAnt")
    @RequestMapping("/**/testAnt")
    public String testAnt() {
        return "success";
    }

    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable Integer id, @PathVariable String username) {
        System.out.println("id = " + id);
        System.out.println("username = " + username);
        return "success";
    }
}
