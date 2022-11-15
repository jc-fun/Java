package com.urain.qqzone.dao.impl;

import com.urain.myssm.basedao.BaseDAO;
import com.urain.qqzone.dao.HostReplyDAO;
import com.urain.qqzone.pojo.HostReply;
import com.urain.qqzone.pojo.Reply;

import java.time.LocalDateTime;

/**
 * @Author: supertain
 * @Date: 2022/4/14 9:54
 * @Description:
 */
public class HostReplyDAOImpl extends BaseDAO<HostReply> implements HostReplyDAO {
    @Override
    public HostReply getHostReplyByReplyId(Integer replyId) {
        return load("select * from t_host_reply where reply = ?", replyId);
    }

    @Override
    public void addHostReply(HostReply hostReply) {
        executeUpdate("insert into t_host_reply values(0, ?, ?, ?, ?)", hostReply.getContent(), hostReply.getHostReplyDate(), hostReply.getAuthor().getId(), hostReply.getReply().getId());
    }

    @Override
    public void delHostReply(Integer id) {
        executeUpdate("delete from t_host_reply where id = ?", id);
    }
}
