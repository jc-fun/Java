package com.urain.myssm.trans;

import com.urain.myssm.basedao.ConnUtil;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: supertain
 * @Date: 2022/4/10 21:47
 * @Description:
 */
public class TransactionManager {


    // 开启事务
    public static void beginTrans() throws SQLException {
        ConnUtil.getConn().setAutoCommit(false);
    }

    // 提交事务
    public static void commit() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.commit();
        ConnUtil.closeConn();
    }

    // 回滚事务
    public static void rollback() throws SQLException {
        Connection conn = ConnUtil.getConn();
        conn.rollback();
        ConnUtil.closeConn();
    }
}
