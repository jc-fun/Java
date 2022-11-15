package com.urain.qqzone.controller;


import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.TopicService;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;


/**
 * @Author: supertain
 * @Date: 2022/4/14 9:07
 * @Description:
 */
public class TopicController {

    private TopicService topicService;

    public String topicDetail(Integer id, HttpSession session) {

        /*
        // String -> java.util.Date
        String dateStr = "2022-04-16";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Date -> String
        Date date1 = new Date();
        String dateStr2 = sdf.format(date1);
        */


        Topic topic = topicService.getTopicById(id);

        session.setAttribute("topic", topic);
        return "frames/detail";
    }

    public String delTopic(Integer topicId) {
        topicService.delTopic(topicId);
        return "redirect:topic.do?operate=getTopicList";
    }

    public String getTopicList(HttpSession session) {
        // 从session中获取当前用户信息
        UserBasic userBasic = (UserBasic) session.getAttribute("userBasic");
        // 再次查询当前用户关联的所有日志
        List<Topic> topicList = topicService.getTopicList(userBasic);
        // 设置一下关联的日志列表
        userBasic.setTopicList(topicList);
        // 重新覆盖friend中的信息
        session.setAttribute("friend", userBasic);
        return "frames/main";
    }
}
