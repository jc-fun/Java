package com.urain.securitydemo1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: urain
 * @Date: 2022/5/14 23:21
 * @Description:
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {

    private Integer id;
    private String username;
    private String password;


}
