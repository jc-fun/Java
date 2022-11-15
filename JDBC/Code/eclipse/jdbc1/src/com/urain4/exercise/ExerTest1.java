package com.urain4.exercise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.urain.util.JDBCUtils;

public class ExerTest1 {

	@Test
	public void testInsert() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入用户名");
		String name = scanner.next();
		System.out.print("请输入邮箱");
		String email = scanner.next();
		System.out.print("请输入生日");
		String birthday = scanner.next();
		String sql = "insert into customers(name, email, birth) values(?, ?, ?)";
		int insertCount = update(sql, name, email, birthday);
		if (insertCount > 0) {
			System.out.println("添加成功");
		} else {
			System.out.println("添加失败");
		}
		scanner.close();
	}

	// 通用的增删改操作
	public int update(String sql, Object... args) { // SQL中占位符的个数，应与可变形参的长度一致
		// 1.获取数据库的连接
		Connection conn = null;
		// 2.预编译SQL语句，返回PreparedStatement的实例
		PreparedStatement ps = null;
		try {
			conn = JDBCUtils.getConnection();
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			// 4.执行
			/*
			 * ps.execute()
			 * 如果执行的是查询操作，且又返回结果，则返回true
			 * 如果执行的是增删改操作，或没有返回结果，则返回false
			 */
			// 方式一：
			// return ps.execute();
			// 方式二：
			return ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;
	}
}
