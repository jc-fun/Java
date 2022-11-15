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
 * @Date: 2022/8/22 22:56
 * @Version: 1.0.0
 * @Description: TODO
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserService userService2;


    @RequestMapping("/userDetail")
    public String userDetail(Model model, Integer id, String username) {
        User user = userService.queryUserById(id, username);
        User user2 = userService2.queryUserById(id, username);

        model.addAttribute("user", user);
        model.addAttribute("user2", user2);

        return "userDetail";
    }


}
