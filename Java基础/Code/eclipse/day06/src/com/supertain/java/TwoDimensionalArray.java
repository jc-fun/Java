package com.supertain.java;

/*
 * 
 */

public class TwoDimensionalArray {
	public static void main(String[] args) {
		int[] arr = new int[] {1, 2, 3}; // 一维数组
		//静态初始化
		int[][] arr1 = new int[][] {{1, 2, 3}, {4, 5}, {6, 7, 8}};
		//动态初始化1
		String[][] arr2 = new String[3][2];
		//动态初始化2
		String[][] arr3 = new String[3][];
		
		int[][] arr4 = {{1, 2, 3}, {4, 5, 6}}; // 类型推断
		// 中括号位置可变
		int[] arr5[] = {{1, 2, 3}, {4, 5, 6}};
		int arr6[][] = {{1, 2, 3}, {4, 5, 6}};
		
		System.out.println(arr1[1][1]); //5
		System.out.println(arr2[1][1]); //null
		
		// 获取数组的长度
		System.out.println(arr1.length); // 3
		System.out.println(arr1[1].length); // 2
		
		int arr7[][] = new int[3][];
		System.out.println(arr7[1]); // null,即空指针
		arr7[1] = new int[4]; // 未指定会报错
		System.out.println(arr7[1][0]); // 0
		System.out.println(arr7[1]); // 地址
		
		int arr8[][] = new int[3][4];
		System.out.println(arr8[1]); // 地址
		System.out.println(arr8[1][3]); // 0
	}
}
