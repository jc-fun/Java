package com.urain.spring5.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author: urain
 * @date: 2022/4/25 14:43
 * @description:
 * @version: 1.0
 */

@Configuration  // 配置类
@ComponentScan(basePackages = "com.urain")
public class TxConfig {

}
