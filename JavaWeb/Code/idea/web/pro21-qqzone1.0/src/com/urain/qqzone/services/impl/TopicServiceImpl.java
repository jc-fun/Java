package com.urain.qqzone.services.impl;

import com.urain.qqzone.dao.TopicDAO;
import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.TopicService;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 17:16
 * @Description:
 */
public class TopicServiceImpl implements TopicService {
    private TopicDAO topicDAO = null;

    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        //
        return topicDAO.getTopicList(userBasic);
    }
}
