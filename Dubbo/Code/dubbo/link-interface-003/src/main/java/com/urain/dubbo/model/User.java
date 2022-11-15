package com.urain.dubbo.model;

import java.io.Serializable;

/**
 * @ClassName: User
 * @Package: com.urain.dubbo.model
 * @Author: urain
 * @Date: 2022/8/17 21:24
 * @Version: 1.0.0
 * @Description: TODO
 */
public class User implements Serializable {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
