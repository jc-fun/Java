package com.urain.myssm.basedao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: supertain
 * @Date: 2022/4/10 21:55
 * @Description:
 */
public class ConnUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();
//    public static String DRIVER;
//    public static String URL;
//    public static String USER;
//    public static String PWD;
static Properties properties = new Properties();
    static {
        InputStream is = ConnUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(is);
//            DRIVER = properties.getProperty("jdbc.driver");
//            URL = properties.getProperty("jdbc.url");
//            USER = properties.getProperty("jdbc.user");
//            PWD = properties.getProperty("jdbc.pwd");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Connection createConn() {
        try {

            DataSource druidDataSource = DruidDataSourceFactory.createDataSource(properties);
            /*
            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(DRIVER);
            druidDataSource.setUrl(URL);
            druidDataSource.setUsername(USER);
            druidDataSource.setPassword(PWD);
            druidDataSource.setMaxWait(5000);
            druidDataSource.setMinIdle(3);
            druidDataSource.setMaxActive(10);
            */

            return druidDataSource.getConnection();
            //1.加载驱动
            //Class.forName(DRIVER);
            //2.通过驱动管理器获取连接对象
            //return DriverManager.getConnection(URL, USER, PWD);
        } catch (/*ClassNotFoundException | */Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Connection getConn() {
        Connection conn = threadLocal.get();
        if (conn == null) {
            conn = createConn();
            threadLocal.set(conn);
        }
        return conn;
    }

    public static void closeConn() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn == null) {
            return;
        }
        if (!conn.isClosed()) {
            conn.close();
//            threadLocal.set(null);
            threadLocal.remove();
        }
    }
}
