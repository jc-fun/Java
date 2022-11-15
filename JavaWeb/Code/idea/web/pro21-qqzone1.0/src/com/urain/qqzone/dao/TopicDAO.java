package com.urain.qqzone.dao;

import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 15:29
 * @Description:
 */
public interface TopicDAO {
    // 获取指定用户的所有日志
    public List<Topic> getTopicList(UserBasic userBasic);

    // 添加日志
    public void addTopic(Topic topic);

    // 删除日志
    void delTopic(Topic topic);

    // 获取特定日志信息
    Topic getTopic(Integer id);
}
