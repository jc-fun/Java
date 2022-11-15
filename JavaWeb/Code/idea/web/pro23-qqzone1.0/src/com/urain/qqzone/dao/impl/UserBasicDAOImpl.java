package com.urain.qqzone.dao.impl;

import com.urain.myssm.basedao.BaseDAO;
import com.urain.qqzone.dao.UserBasicDAO;
import com.urain.qqzone.pojo.UserBasic;

import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/11 15:42
 * @Description:
 */
public class UserBasicDAOImpl extends BaseDAO<UserBasic> implements UserBasicDAO {

    @Override
    public UserBasic getUserBasic(String loginId, String pwd) {
        return super.load("select * from t_user_basic where loginId = ? and pwd = ?", loginId, pwd);
    }

    @Override
    public List<UserBasic> getUserBasicList(UserBasic userBasic) {
        String sql = "select fid id from t_friend where uid = ?";
        return super.executeQuery(sql, userBasic.getId());
    }

    @Override
    public UserBasic getUserBasicById(Integer fid) {
        return load("select * from t_user_basic where id = ?", fid);
    }
}
