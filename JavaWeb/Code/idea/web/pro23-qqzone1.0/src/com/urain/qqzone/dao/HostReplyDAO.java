package com.urain.qqzone.dao;

import com.urain.qqzone.pojo.HostReply;
import com.urain.qqzone.pojo.Reply;

/**
 * @Author: supertain
 * @Date: 2022/4/11 15:41
 * @Description:
 */
public interface HostReplyDAO {
    // 根据replyId查询关联的HostReply实体
    HostReply getHostReplyByReplyId(Integer replyId);

    // 添加主人回复
    void addHostReply(HostReply hostReply);

    // 删除；特定的HostReply
    void delHostReply(Integer id);
}
