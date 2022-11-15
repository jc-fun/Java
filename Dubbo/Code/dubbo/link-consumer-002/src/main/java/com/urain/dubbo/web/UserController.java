package com.urain.dubbo.web;

import com.urain.dubbo.model.User;
import com.urain.dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: UserController
 * @Package: com.urain.dubbo.web
 * @Author: urain
 * @Date: 2022/8/15 22:27
 * @Version: 1.0.0
 * @Description: TODO
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String userDetail(Model model, Integer id) {
        User user = userService.queryUserById(id);
        System.out.println("user = " + user);
        model.addAttribute("user", user);
        return "userDetail";
    }


}
