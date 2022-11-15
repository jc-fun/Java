package com.urain.springboot.boot.controller;

import com.urain.springboot.boot.bean.Person;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @Author: urain
 * @Date: 2022/5/10 21:55
 * @Description:
 * @Version: 1.0
 */
@Controller
public class ResponseTestController {



    @ResponseBody  // --RequestResponseBodyMethodProcessor --> messageConverter
    @GetMapping("hell")
    public FileSystemResource file() {

        // 文件以这样的方式返回看是谁处理的(messageConverter)
        return null;
    }


    /**
     * @Author: urain
     * @Date: 2022/5/11 14:45
     * @Description:
     *  1.如果是浏览器发送请求直接返回xml    application/xml   jacksonXmlConverter
     *  2.如果是ajax请求，返回json    application/json    jacksonJsonConverter
     *  3.如果是APP发请求，返回自定义类型数据     application/xxx    xxxConverter
     *  步骤：
     *  1.添加自定义的MessageConverter进系统底层
     *  2.系统底层就会统计出所有的MessageConverter能操作哪些数据
     *  3.客户端内容协商 xxx --> xxx
     * @Version: 1.0
    */

    @ResponseBody // 利用返回值处理器里面的消息转换器进行处理
    @GetMapping(value = "/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(28);
        person.setBoss(true);
        person.setBirth(new Date());
        person.setUserName("张三");
        return person;
    }

}
