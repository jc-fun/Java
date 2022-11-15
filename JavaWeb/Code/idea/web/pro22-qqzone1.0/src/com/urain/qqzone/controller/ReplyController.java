package com.urain.qqzone.controller;

import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.ReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @Author: supertain
 * @Date: 2022/4/14 16:15
 * @Description:
 */
public class ReplyController {

    private ReplyService replyService;

    public String addReply(String content,Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic)session.getAttribute("userBasic");
        Reply reply = new Reply(content, LocalDateTime.now(), author, new Topic(topicId));
        replyService.addReply(reply);

        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }

    public String delReply(Integer replyId, HttpSession session) {
        replyService.delReply(replyId);
        Topic topic = (Topic)session.getAttribute("topic");
        return "redirect:topic.do?operate=topicDetail&id=" + topic.getId();
    }
}
