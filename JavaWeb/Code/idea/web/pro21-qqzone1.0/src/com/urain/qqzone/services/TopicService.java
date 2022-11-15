package com.urain.qqzone.services;

import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 17:15
 * @Description:
 */
public interface TopicService {
    // 查询特定用户的日志列表
    List<Topic> getTopicList(UserBasic userBasic);

}
