package com.urain.qqzone.services;

import com.urain.qqzone.pojo.HostReply;

/**
 * @Author: supertain
 * @Date: 2022/4/14 9:49
 * @Description:
 */
public interface HostReplyService {
    HostReply getHostReplyByReplyId(Integer replyId);

    // 添加主人回复
    void addHostReply(HostReply hostReply);

    // 删除主人回复
    void delHostReply(Integer id);
}
