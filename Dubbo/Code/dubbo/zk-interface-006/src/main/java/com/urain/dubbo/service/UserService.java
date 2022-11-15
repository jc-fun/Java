package com.urain.dubbo.service;

import com.urain.dubbo.model.User;

/**
 * @ClassName: UserService
 * @Package: com.urain.dubbo.model.service
 * @Author: urain
 * @Date: 2022/8/18 23:44
 * @Version: 1.0.0
 * @Description: TODO
 */
public interface UserService {

    /**
     * @Author: urain
     * @Date: 2022/8/18 23:44
     * @MethodName: queryUserById
     * @Param: null
     * @Return:
     * @Since: JDK 11
     * @Description: 根据用户标识获取用户信息
     */
    User queryUserById(Integer id, String username);


}
