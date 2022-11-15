package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: urain
 * @date: 2022/4/27 22:21
 * @description:
 * @version: 1.0
 */

@Controller
public class TestController {

    @RequestMapping("/**/testInterceptor")
    public String testInterceptor() {
        return "success";
    }

    @RequestMapping("testExceptionHandler")
    public String testExceptionHandler() {
        System.out.println(1 / 0);
        return "success";
    }

}
