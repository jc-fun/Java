package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: urain
 * @date: 2022/4/28 16:09
 * @description:
 * @version: 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
