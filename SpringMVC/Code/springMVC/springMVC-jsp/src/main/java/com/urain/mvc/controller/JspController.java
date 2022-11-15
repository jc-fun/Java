package com.urain.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: urain
 * @date: 2022/4/26 22:57
 * @description:
 * @version: 1.0
 */

@Controller
public class JspController {

    @RequestMapping("/success")
    public String success() {
        return "success";
    }
}
