package com.urain.spring5.service;

import com.urain.spring5.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author: urain
 * @date: 2022/4/25 10:09
 * @description:
 * @version: 1.0
 */

@Service
@Transactional(readOnly = false, timeout = -1, propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
public class UserService {

    // 注入dao
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;


    // 转账的方法
    public void accountMoney() {
        // 声明式事务管理
        //lucy少100
        userDAO.reduceMoney();

        // 模拟异常
        int i = 10 / 0;

        // mary多100
        userDAO.addMoney();


        // 编程式事务管理
//        TransactionDefinition def = new DefaultTransactionDefinition();
//        // 1.开启事务
//        TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
//        // getTransaction用于开启事务，返回TransactionStatus实例对象
//        // 可以不传def,getTransaction会创建默认的DefaultTransactionDefinition
//        // 即TransactionStatus status = dataSourceTransactionManager.getTransaction(null);
//
//        try {
//
//            // 2.进行业务操作
//            // lucy少100
//            userDAO.reduceMoney();
//
//            // 模拟异常
////            int i = 10 / 0;
//
//            // mary多100
//            userDAO.addMoney();
//
//            // 3.提交事务
//            dataSourceTransactionManager.commit(status);
//        } catch (Exception e) {
//            // 4.回滚事务
//            dataSourceTransactionManager.rollback(status);
//            throw new RuntimeException("转账失败" + e);
//        }
    }
}
