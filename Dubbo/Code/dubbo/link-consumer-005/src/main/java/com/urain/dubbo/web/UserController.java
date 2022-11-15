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
 * @Date: 2022/8/17 22:25
 * @Version: 1.0.0
 * @Description: TODO
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author: urain
     * @Date: 2022/8/17 22:27
     * @MethodName: userDetail
     * @Param: null
     * @Return:
     * @Since: JDK 11
     * @Description: 根据用户标识获取用户详情
     */
    @RequestMapping("/userDetail")
    public String userDetail(Model model, Integer id) {
        User user = userService.queryUserById(id);

        Integer allUserCount = userService.queryAllUserCount();

        model.addAttribute("user", user);
        model.addAttribute("allUserCount", allUserCount);

        return "userDetail";
    }

}
