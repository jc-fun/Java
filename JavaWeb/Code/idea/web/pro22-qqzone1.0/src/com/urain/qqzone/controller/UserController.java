package com.urain.qqzone.controller;

import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.TopicService;
import com.urain.qqzone.services.UserBasicService;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 17:49
 * @Description:
 */
public class UserController {

    private UserBasicService userBasicService;
    private TopicService topicService;

    public String login(String loginId, String pwd, HttpSession session) {
        UserBasic userBasic = userBasicService.login(loginId, pwd);
        if(userBasic != null) {
            List<UserBasic> friendList = userBasicService.getFriendList(userBasic);
            List<Topic> topicList = topicService.getTopicList(userBasic);
            userBasic.setFriendList(friendList);
            userBasic.setTopicList(topicList);
            // userBasic保存的是登陆者的信息
            // friend保存的是当前进入的是谁的空间
            session.setAttribute("userBasic", userBasic);
            session.setAttribute("friend", userBasic);
            return "index";
        } else {
            return "login";
        }
    }

    public String friend(Integer id, HttpSession session) {
        // 1.根据id获取指定用户信息
        UserBasic currFriend = userBasicService.getUserBasicByid(id);
        List<Topic> topicList = topicService.getTopicList(currFriend);
        currFriend.setTopicList(topicList);
        session.setAttribute("friend", currFriend);
        return "index";
    }
}
