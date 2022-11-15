package com.urain2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.urain2.bean.Customer;

/**
 * 
 * @Description 用于规范针对于customer表的常用操作
 * @author supertain Email:fange625521233@gmail.com
 * @version
 * @date 2022年4月2日下午1:25:55
 */

public interface CustomerDAO {
	/**
	 * 
	 * @Description 将cust对象添加到数据库中
	 * @author supertain
	 * @date 2022年4月2日下午1:30:09
	 * @param conn
	 * @param cust
	 */
	void insert(Connection conn, Customer cust);

	/**
	 * 
	 * @Description 针对指定的id，删除表中的一条记录
	 * @author supertain
	 * @date 2022年4月2日下午1:31:14
	 * @param conn
	 * @param id
	 */
	void deleteById(Connection conn, int id);

	/**
	 * 
	 * @Description 针对于内存中的cust对象，去修改数据库表中指定的记录
	 * @author supertain
	 * @date 2022年4月2日下午1:33:08
	 * @param conn
	 * @param cust
	 */
	void update(Connection conn, Customer cust);

	Customer getCustomerById(Connection conn, int id);

	/**
	 * 
	 * @Description 查询表中的所有记录构成的集合
	 * @author supertain
	 * @date 2022年4月2日下午1:33:08
	 * @param conn
	 * @return
	 */
	List<Customer> getAll(Connection conn);

	/**
	 * 
	 * @Description 返回数据表中的数据的条目数
	 * @author supertain
	 * @date 2022年4月2日下午1:33:08
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);

	/**
	 * 
	 * @Description 返回数据表中最大的生日
	 * @author supertain
	 * @date 2022年4月2日下午1:33:08
	 * @param conn
	 * @return
	 */
	Date getMaxBirth(Connection conn);
}
