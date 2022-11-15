package com.urain3.preparedstatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.urain.util.JDBCUtils;
import com.urain3.bean.Customer;
import com.urain3.bean.Order;

/**
 * 
 * @Description 使用PreparedStatement实现针对于不同表的通用的查询操作
 * @author supertain Email:fange625521233@gmail.com
 * @version
 * @date 2022年4月1日上午10:06:13
 */

public class PreparedStatementQueryTest {
	
	@Test
	public void testGetForList() {
		String sql = "select id, name, email from customers where id < ?";
		List<Customer> list = getForList(Customer.class, sql, 12);
		list.forEach(System.out::println);
		
		String sql1 = "select order_id orderId, order_name orderName from `order` where order_id < ?";
		List<Order> orderList = getForList(Order.class, sql1, 5);
		orderList.forEach(System.out::println);
	}
	
	
	public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			// 创建集合对象
			ArrayList<T> list = new ArrayList<T>();
			while(rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();
				
				// 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
				for(int i = 0; i < columnCount; i++) {
					// 获取列值
					Object columnValue = rs.getObject(i + 1);
					// 获取每个列的列名
					String columnLabel = rsmd.getColumnLabel(i + 1);
					
					// 给cust对象指定的columnName属性赋值为columnValue，通过反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
					
				}
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
	
	
	
	@Test
	public void testGetInstance() {
		String sql = "select id, name, email from customers where id = ?";
		Customer customer = getInstance(Customer.class, sql, 12);
		System.out.println(customer);
		
		String sql1 = "select order_id orderId, order_name orderName from `order` where order_id = ?";
		Order order = getInstance(Order.class, sql1, 1);
		System.out.println(order);
	}
	
	
	/**
	 * 
	 * @Description 针对于不同的表的通用查询操作，返回表中的一条记录
	 * @author supertain
	 * @date 2022年4月1日上午10:22:34
	 * @param <T>
	 * @param clazz
	 * @param sql
	 * @param args
	 * @return
	 */
	public <T> T getInstance(Class<T> clazz, String sql, Object ...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();
			
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 通过ResultSetMetaData获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			
			if(rs.next()) {
				T t = clazz.getDeclaredConstructor().newInstance();
				
				// 处理结果集一行数据中的每一个列
				for(int i = 0; i < columnCount; i++) {
					// 获取列值
					Object columnValue = rs.getObject(i + 1);
					// 获取每个列的列名
					String columnLabel = rsmd.getColumnLabel(i + 1);
					
					// 给cust对象指定的columnName属性赋值为columnValue，通过反射
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnValue);
					
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(conn, ps, rs);
		}
		return null;
	}
	
}
