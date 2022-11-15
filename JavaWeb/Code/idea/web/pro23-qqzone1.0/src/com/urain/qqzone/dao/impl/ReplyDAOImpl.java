package com.urain.qqzone.dao.impl;

import com.urain.myssm.basedao.BaseDAO;
import com.urain.qqzone.dao.ReplyDAO;
import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/14 10:21
 * @Description:
 */
public class ReplyDAOImpl extends BaseDAO<Reply> implements ReplyDAO {
    @Override
    public List<Reply> getReplyList(Topic topic) {
        return executeQuery("select * from t_reply where topic = ?", topic.getId());
    }

    @Override
    public void addReply(Reply reply) {
        executeUpdate("insert into t_reply values(0, ?, ?, ?, ?)", reply.getContent(), reply.getReplyDate(), reply.getAuthor().getId(), reply.getTopic().getId());
    }

    @Override
    public void delReply(Integer id) {
        executeUpdate("delete from t_reply where id = ?", id);
    }

    @Override
    public Reply getReply(Integer id) {
        return load("select * from t_reply where id = ?", id);
    }
}
