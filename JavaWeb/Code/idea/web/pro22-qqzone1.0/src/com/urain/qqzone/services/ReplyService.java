package com.urain.qqzone.services;

import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/14 9:21
 * @Description:
 */
public interface ReplyService {
    // 根据topic的id获取关联的所有的回复
    List<Reply> getReplyListByTopicID(Integer topicId);

    // 添加回复
    void addReply(Reply reply);

    // 删除指定的回复
    void delReply(Integer id);

    // 删除指定的日志关联的所有的回复
    void delReplyList(Topic topic);
}
