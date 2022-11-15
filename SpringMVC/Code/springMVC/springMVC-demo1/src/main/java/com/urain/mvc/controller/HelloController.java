package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: urain
 * @date: 2022/4/25 21:43
 * @description:
 * @version: 1.0
 */

@Controller
public class HelloController {
    // "/" --> /WEB-INF/templates/index.html

    @RequestMapping("/")
    public String index() {
        // 返回视图名称
        return "index";
    }

    @RequestMapping("/target")
    public String toTarget() {
        return "target";
    }
}
