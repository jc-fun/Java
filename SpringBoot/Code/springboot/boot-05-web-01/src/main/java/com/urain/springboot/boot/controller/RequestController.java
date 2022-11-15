package com.urain.springboot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: urain
 * @Date: 2022/5/9 16:35
 * @Description:
 * @Version: 1.0
 */
@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "success");
        request.setAttribute("code", 200);
        return "forward:/success";  // 转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute(value = "msg", required = false) String msg,
                                       @RequestAttribute(value = "code", required = false) Integer code,
                                       HttpServletRequest request) {
        Object msg1 = request.getAttribute("msg");
        Map<String, Object> map = new HashMap<>();

        Object hello = request.getAttribute("hello");
        Object world = request.getAttribute("world");
        Object message = request.getAttribute("message");

        map.put("reqMethod_msg", msg1);
        map.put("annotation_msg", msg);
        map.put("code", code);
        map.put("hello", hello);
        map.put("world", world);
        map.put("message", message);

        return map;
    }

    // 1.语法：/cars/sell;low=34;brand=byd,audi,yd
    // 2.springboot默认禁用矩阵变量的功能：
    //          手动开启：对于路径的处理，都是使用URLPathHelper进行解析，
    //          removeSemicolonContent(移除分号内容)支持矩阵变量
    // 3.矩阵变量必须有url路径变量才能被解析{xxx}
    @GetMapping("/cars/{path}")
    @ResponseBody
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low,
                                        @MatrixVariable("brand") List<String> brand,
                                        @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;

    }

    // boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    @ResponseBody
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(value = "age", pathVar = "empId") Integer empAge,
                                    @PathVariable("bossId") String bossId,
                                    @PathVariable("empId") String empId) {
        Map<String, Object> map = new HashMap<>();
        map.put("bossId " + bossId, bossAge);
        map.put("empId " + empId, empAge);
        return map;

    }

    @GetMapping("/params")
    public String testParam(Map<String, Object> map,
                            Model model,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        map.put("hello", "world666");
        model.addAttribute("world", "hello666");
        request.setAttribute("message", "HelloWorld");
        Cookie cookie = new Cookie("c1", "v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/success";

    }

}
