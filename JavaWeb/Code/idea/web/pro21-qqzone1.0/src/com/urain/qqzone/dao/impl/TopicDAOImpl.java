package com.urain.qqzone.dao.impl;

import com.urain.myssm.basedao.BaseDAO;
import com.urain.qqzone.dao.TopicDAO;
import com.urain.qqzone.pojo.Topic;
import com.urain.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 16:13
 * @Description:
 */
public class TopicDAOImpl extends BaseDAO<Topic> implements TopicDAO {


    @Override
    public List<Topic> getTopicList(UserBasic userBasic) {
        return super.executeQuery("select * from t_topic where author = ?", userBasic.getId());
    }

    @Override
    public void addTopic(Topic topic) {

    }

    @Override
    public void delTopic(Topic topic) {

    }

    @Override
    public Topic getTopic(Integer id) {
        return null;
    }
}
