package com.urain.qqzone.services;

import com.urain.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 16:20
 * @Description:
 */
public interface UserBasicService {
    UserBasic login(String loginId, String pwd);

    List<UserBasic> getFriendList(UserBasic userBasic);

    // 根据id获取指定用户信息
    UserBasic getUserBasicByid(Integer id);
}
