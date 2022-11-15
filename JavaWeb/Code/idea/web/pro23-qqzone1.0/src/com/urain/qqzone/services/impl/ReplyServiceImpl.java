package com.urain.qqzone.services.impl;

import com.urain.qqzone.dao.ReplyDAO;
import com.urain.qqzone.pojo.HostReply;
import com.urain.qqzone.pojo.Reply;
import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;
import com.urain.qqzone.services.HostReplyService;
import com.urain.qqzone.services.ReplyService;
import com.urain.qqzone.services.UserBasicService;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/14 9:25
 * @Description:
 */
public class ReplyServiceImpl implements ReplyService {
    private ReplyDAO replyDAO;
    // 此处引入的是其它POJO对应的Service接口，而不是DAO接口
    // 其它POJO对应的业务逻辑是封装在service层的，我需要调用别人的业务逻辑方法，而不要去深入考虑人家内部的细节
    private HostReplyService hostReplyService;
    private UserBasicService userBasicService;

    @Override
    public List<Reply> getReplyListByTopicID(Integer topicId) {
        List<Reply> replyList = replyDAO.getReplyList(new Topic(topicId));
        for (Reply reply : replyList) {
            //1.将关联的作者设置进去
            UserBasic author = userBasicService.getUserBasicByid(reply.getAuthor().getId());
            reply.setAuthor(author);
            //2.将关联的HostReply设置进去
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(reply.getId());
            reply.setHostReply(hostReply);
        }
        return replyList;
    }

    @Override
    public void addReply(Reply reply) {
        replyDAO.addReply(reply);
    }

    @Override
    public void delReply(Integer id) {
        // 1.根据id获取到reply
        Reply reply = replyDAO.getReply(id);
        if (reply != null) {
            HostReply hostReply = hostReplyService.getHostReplyByReplyId(id);
            // 2.如果reply有关联的hostReply,则先删除hostReply
            if (hostReply != null) {
                hostReplyService.delHostReply(hostReply.getId());
            }
            // 3.删除reply
            replyDAO.delReply(id);
        }

    }

    @Override
    public void delReplyList(Topic topic) {
        List<Reply> replyList = replyDAO.getReplyList(topic);
        if(replyList != null) {
            for (Reply reply : replyList) {
                delReply(reply.getId());
            }
        }
    }
}
