package com.urain.qqzone.services.impl;

import com.urain.qqzone.dao.UserBasicDAO;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.UserBasicService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 16:21
 * @Description:
 */
public class UserBasicServiceImpl implements UserBasicService {
    private UserBasicDAO userBasicDAO = null;

    @Override
    public UserBasic login(String loginId, String pwd) {
        UserBasic userBasic = userBasicDAO.getUserBasic(loginId, pwd);
        return userBasic;
    }

    @Override
    public List<UserBasic> getFriendList(UserBasic userBasic) {
        List<UserBasic> userBasicList = userBasicDAO.getUserBasicList(userBasic);
        List<UserBasic> friendList = new ArrayList<>(userBasicList.size());
        for (UserBasic friend : userBasicList) {
            friend = userBasicDAO.getUserBasicById(friend.getId());
            friendList.add(friend);
        }
        return friendList;
    }

    @Override
    public UserBasic getUserBasicByid(Integer id) {
        return userBasicDAO.getUserBasicById(id);
    }


}
