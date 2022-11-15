package com.urain.springboot.boot.controller;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: urain
 * @Date: 2022/5/9 15:55
 * @Description:
 * @Version: 1.0
 */

@RestController
public class ParameterTestController {

    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String name,
                                      @PathVariable Map<String, String> pv,
                                      @RequestHeader("User-Agent") String userAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      @RequestParam("interest") List<String> interests,
                                      @RequestParam Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        map.put("userAgent", userAgent);
        map.put("headers", headers);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
        return map;

    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", URLDecoder.decode(content, StandardCharsets.UTF_8));
        return map;
    }

}
