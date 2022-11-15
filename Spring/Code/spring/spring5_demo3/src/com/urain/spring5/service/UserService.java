package com.urain.spring5.service;

import com.urain.spring5.dao.UserDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: urain
 * @date: 2022/4/23 22:18
 * @description:
 * @version: 1.0
 */

// 在注解里面value属性值可以省略不写  @Component
// 默认值是类名称，首字母小写
// UserService --> userService
@Service
public class UserService {

    @Value(value = "abc")
    private String name;


    // 定义dao类型属性
    // 不需要添加set方法
    // 添加注入属性注解
//    @Autowired // 根据类型进行注入
//    @Qualifier(value = "userDAOImpl1") // 根据名称进行注入，必须配合Autowired使用
//    private UserDAO userDAO;

    //@Resource // 根据类型注入   JDK1.8之后移除了javax扩展，使用Resource注解需要导入扩展
    @Resource(name = "userDAOImpl1") // 根据名称进行注入
    private UserDAO userDAO;

    public void add() {
        System.out.println("service add......" + name);
        userDAO.add();
    }
}
