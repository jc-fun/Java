package com.urain.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * @Description 操作数据库的工具类
 * @author supertain Email:fange625521233@gmail.com
 * @version
 * @date 2022年3月31日下午4:59:50
 */

public class JDBCUtils {
	/**
	 * 
	 * @Description 获取数据库连接
	 * @author supertain
	 * @date 2022年3月31日下午5:04:01
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 1.读取配置文件中的4个基本信息
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");

		// 2.加载驱动
		Class.forName(driverClass);

		// 3.获取连接
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	/**
	 * 
	 * @Description 关闭连接和Statement的操作
	 * @author supertain
	 * @date 2022年3月31日下午5:07:11
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if(ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description 关闭资源的操作
	 * @author supertain
	 * @date 2022年3月31日下午6:46:10
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		try {
			if(ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
