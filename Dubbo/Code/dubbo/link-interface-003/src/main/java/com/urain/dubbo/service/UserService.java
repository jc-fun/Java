package com.urain.dubbo.service;

import com.urain.dubbo.model.User;

/**
 * @ClassName: UserService
 * @Package: com.urain.dubbo.service
 * @Author: urain
 * @Date: 2022/8/17 21:25
 * @Version: 1.0.0
 * @Description: TODO
 */
public interface UserService {

    /**
     * @Author: urain
     * @Date: 2022/8/17 21:43
     * @MethodName: queryUserById
     * @Param: null
     * @Return:
     * @Since: JDK 11
     * @Description: 根据用户标识获取用户信息
     */
    User queryUserById(Integer id);

    /**
     * @Author: urain
     * @Date: 2022/8/17 21:47
     * @MethodName: queryAllUserCount
     * @Param: null
     * @Return:
     * @Since: JDK 11
     * @Description: 查询用户总人数
     */
    Integer queryAllUserCount();

}
