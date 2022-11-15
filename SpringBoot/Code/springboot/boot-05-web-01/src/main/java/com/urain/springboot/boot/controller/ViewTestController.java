package com.urain.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: urain
 * @Date: 2022/5/11 16:31
 * @Description:
 * @Version: 1.0
 */
@Controller
public class ViewTestController {

    @GetMapping("/thymeleaf")
    public String success(Model model) {
        // model中的数据会自动放在请求域中 request.setAttribute()
        model.addAttribute("msg", "Hello Thymeleaf");
        model.addAttribute("url", "https://www.baidu.com");
        return "success";
    }

}
