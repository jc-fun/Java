package com.urain.qqzone.dao;

import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 15:39
 * @Description:
 */
public interface ReplyDAO {
    // 获取指定日志的回复列表
    List<Reply> getReplyList(Topic topic);

    // 添加回复
    void addReply(Reply reply);

    // 删除回复
    void delReply(Integer id);

}
