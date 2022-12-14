package com.supertain.project2.service;

import com.supertain.project2.bean.Customer;

public class CustomerList {

	private Customer[] customers; // 用来保存客户对象的数组
	private int total = 0; // 记录客户的个数
	
	/**
	 * 用來初始化customers数组的构造器
	 * @param totalCustomer: 指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];
	}
	/**
	 * 
	 * @Description 将指定的客户添加到数组中
	 * @author supertain
	 * @date 2022年1月26日下午9:17:32
	 * @param customer
	 * @return true: 添加成功  false: 添加失败
	 */
	public boolean addCustomer(Customer customer) {
		if(total >= customers.length) {
			return false;
		}
		customers[total++] = customer;
		return true;
	}
	/**
	 * 
	 * @Description 修改指定索引位置的客户信息
	 * @author supertain
	 * @date 2022年1月26日下午9:20:53
	 * @param index
	 * @param cust
	 * @return true: 修改成功  false: 修改失败
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total) {
			return false;
		}
		customers[index] = cust;
		return true;
	}
	/**
	 * 
	 * @Description 删除指定索引位置上的客户
	 * @author supertain
	 * @date 2022年1月26日下午9:25:22
	 * @param index
	 * @return true: 删除成功  false: 删除失败
	 */
	public boolean deleteCustomer(int index) {
		if(index < 0 || index >= total) {
			return false;
		}
		for(int i = 0; i < total - 1; i++) {
			customers[i] = customers[i + 1];
			// 最大的索引位置空
			customers[--total] = null;
		}
		return true;
	}
	/**
	 * 
	 * @Description 获取所有的客户信息
	 * @author supertain
	 * @date 2022年1月26日下午9:35:23
	 * @return
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];
		for(int i = 0; i < total; i++) {
			custs[i] = customers[i];
		}
		return custs;
	}
	/**
	 * 
	 * @Description 获取指定索引位置上的客户
	 * @author supertain
	 * @date 2022年1月26日下午9:40:06
	 * @param index
	 * @return 如果找到了元素则返回该元素,否则返回null
	 */
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total) {
			return null;
		}
		return customers[index];
	}
	/**
	 * 
	 * @Description 获取客户的总数
	 * @author supertain
	 * @date 2022年1月26日下午9:42:24
	 * @return
	 */
	public int getTotal() {
		return total;
	}

}
