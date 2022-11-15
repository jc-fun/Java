package com.urain.dubbo.service;

import com.urain.dubbo.model.User;

/**
 * @Author: urain
 * @Date: 2022/8/13 18:24
 * @Description:
 * @Version: 1.0
 */
public interface UserService {

    /**
     * @Author: urain
     * @Date: 2022/8/13 18:47
     * @Param:
     * @Return:
     * @Since: JDK 11
     * @Description: 根据用户标识获取用于信息
     */
    User queryUserById(Integer id);


}
