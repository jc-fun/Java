package com.urain.mvc.controller;

import com.urain.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author: urain
 * @date: 2022/4/27 15:14
 * @description:
 * @version: 1.0
 */

@Controller
public class HttpController {

    @RequestMapping("testRequestBody")
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println("requestBody: " + URLDecoder.decode(requestBody, StandardCharsets.UTF_8));
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        // 当前requestEntity表示整个请求报文的信息
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + URLDecoder.decode(Objects.requireNonNull(requestEntity.getBody()), StandardCharsets.UTF_8));
        return "success";
    }

    @RequestMapping("testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print("hello, 响应体");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser() {
        return new User(1001, "张三", "123456", 23, "男");
    }

    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username, String password) {
        System.out.println("username = " + username + ", password" + password);
        return "hello, axios";
    }

}
