package com.urain.qqzone.services.impl;

import com.urain.qqzone.dao.TopicDAO;
import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.ReplyService;
import com.urain.qqzone.services.TopicService;
import com.urain.qqzone.services.UserBasicService;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 17:16
 * @Description:
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO = null;
    private ReplyService replyService;
    private UserBasicService userBasicService;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return topicDAO.getTopicList(userBasic);
    }

    @Override
    public Topic getTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        UserBasic author = topic.getAuthor();
        author = userBasicService.getUserBasicByid(author.getId());
        topic.setAuthor(author);
        return topic;
    }

    @Override
    public void delTopic(Integer id) {
        Topic topic = topicDAO.getTopic(id);
        if (topic != null) {
            replyService.delReplyList(topic);
            topicDAO.delTopic(topic);
        }
    }

    @Override
    public Topic getTopicById(Integer id) {
        Topic topic = getTopic(id);
        List<Reply> replyList = replyService.getReplyListByTopicID(topic.getId());
        topic.setReplyList(replyList);
        return topic;
    }
}
