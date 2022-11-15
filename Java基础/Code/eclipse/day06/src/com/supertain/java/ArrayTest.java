package com.supertain.java;

import java.util.Iterator;

/*
 * 
 */
public class ArrayTest {
	public static void main(String[] args) {
		//变量的声明和初始化
		int num; //声明
		num = 10; //初始化
		int id = 1001; //声明 + 初始化
		
		//1.一维数组的声明和初始化
		int[] arr; //声明
		//1.1静态初始化: 数组的初始化和数组元素的赋值操作同时进行
		arr = new int[] {1001, 1002, 1003, 1004};
		//1.2动态初始化: 数组的初始化和数组元素的赋值操作分开进行
		String[] names = new String[5];
		
		// 数组一旦初始化完成，其长度就确定了
		int[] arr2 = {1, 2, 3}; // 类型推断
		int arr3[] = {1, 2, 3}; // 中括号的位置可变
		
		
		//2.数组元素的调用
		names[0] = "小明";
		names[1] = "小红";
		names[2] = "小蓝";
		names[3] = "小紫";
		names[4] = "小黑";
		for (int index = 0; index < names.length; index++) {
			System.out.println(names[index]);
		}
		
	}
}
