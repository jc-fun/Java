package com.urain.qqzone.controller;

import com.urain.qqzone.pojo.HostReply;
import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.HostReplyService;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @Author: supertain
 * @Date: 2022/4/14 17:35
 * @Description:
 */
public class HostReplyController {
    private HostReplyService hostReplyService;

    public String addHostReply(String content, Integer replyId, Integer topicId, HttpSession session) {
        UserBasic author = (UserBasic) session.getAttribute("userBasic");
        HostReply hostReply = new HostReply(content, LocalDateTime.now(), author, new Reply(replyId));
        hostReplyService.addHostReply(hostReply);

        return "redirect:topic.do?operate=topicDetail&id=" + topicId;
    }
}
