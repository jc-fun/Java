package com.urain.book.dao.impl;

import com.urain.book.dao.UserDAO;
import com.urain.book.pojo.User;
import com.urain.myssm.basedao.BaseDAO;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:47
 * @Description:
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User getUser(String uname, String pwd) {
        return load("select * from t_user where uname like ? and pwd like ?", uname, pwd);
    }

    @Override
    public void addUser(User user) {
        executeUpdate("insert into t_user values(0, ?, ?, ?, 0)", user.getUname(), user.getPwd(), user.getEmail());
    }

    @Override
    public User getUser(String uname) {
        return load("select * from t_user where uname = ?", uname);
    }
}
