package com.urain.qqzone.services.impl;

import com.urain.qqzone.dao.HostReplyDAO;
import com.urain.qqzone.pojo.HostReply;
import com.urain.qqzone.services.HostReplyService;

/**
 * @Author: supertain
 * @Date: 2022/4/14 9:51
 * @Description:
 */
public class HostReplyServiceImpl implements HostReplyService {

    private HostReplyDAO hostReplyDAO;

    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return hostReplyDAO.getHostReplyByReplyId(replyId);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        hostReplyDAO.addHostReply(hostReply);
    }

    @Override
    public void delHostReply(Integer id) {
        hostReplyDAO.delHostReply(id);
    }
}
