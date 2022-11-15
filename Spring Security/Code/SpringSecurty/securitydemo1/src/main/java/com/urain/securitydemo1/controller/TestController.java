package com.urain.securitydemo1.controller;

import com.urain.securitydemo1.entity.Users;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: urain
 * @Date: 2022/5/14 21:21
 * @Description:
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/hello")
    public String add() {
        return "hello security";
    }


    @GetMapping("index")
    public String index() {
        return "hello index";
    }

    // @Secured({"ROLE_sale", "ROLE_manager"})
    // @PreAuthorize("hasAnyAuthority('admins')")
    @PostAuthorize("hasAnyAuthority('admins')")
    @GetMapping("/update")
    public String update() {
        System.out.println("hello update...");
        return "hello update";
    }


    @GetMapping("getAll")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<Users> getAllUser(){
        ArrayList<Users> list = new ArrayList<>();
        list.add(new Users(11,"admin1","6666"));
        list.add(new Users(21,"admin2","888"));
        System.out.println(list);
        return list;
    }


    @PostMapping("getTestPreFilter")
    @PostAuthorize("hasAnyAuthority('admins')")
    @PreFilter(value = "filterObject.id%2==0")
    public List<Users> getTestPreFilter(@RequestBody List<Users> list){
        list.forEach(t-> {
            System.out.println(t.getId()+"\t"+t.getUsername());
        });
        return list;
    }


}
