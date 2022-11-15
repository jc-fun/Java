package com.supertain.java;
/*
 * 数组元素的初始化值
 * 	> 数组元素是整形: 0
 * 	> 数组元素是浮点型: 0.0
 *  > 数组元素是char型: 0或'\u0000',而非'0'
 *  > 数组元素是boolean型: false
 *  
 *  > 数组元素是引用数据类型: null
 */
public class ArrayTest1 {
	public static void main(String[] args) {
		//数组元素的默认初始化值
		int[] arr = new int[4];
		for(int index = 0; index < arr.length; index++) {
			System.out.println(arr[index]); // 0 0 0 0
		}
		
		System.out.println("*******************");
		short[] arr1 = new short[4];
		for(int index = 0; index < arr1.length; index++) {
			System.out.println(arr1[index]); // 0 0 0 0
		}
		
		System.out.println("*******************");
		float[] arr2 = new float[4];
		for(int index = 0; index < arr2.length; index++) {
			System.out.println(arr2[index]); // 0.0 0.0 0.0 0.0
		}
		
		System.out.println("*******************");
		double[] arr3 = new double[4];
		for(int index = 0; index < arr3.length; index++) {
			System.out.println(arr3[index]); // 0.0 0.0 0.0 0.0
		}
		
		System.out.println("*******************");
		char[] arr4 = new char[4];
		for(int index = 0; index < arr4.length; index++) {
			System.out.println("---" + arr4[index] + "***"); //--- ***,--- ***,--- ***,--- ***
		}
		if(arr4[0] == 0) {
			System.out.println("true");
		}
		
		System.out.println("*******************");
		boolean[] arr5 = new boolean[4];
		for(int index = 0; index < arr5.length; index++) {
			System.out.println(arr5[index]); // false false false false
		}
		
		System.out.println("*******************");
		String[] arr6 = new String[4];
		for(int index = 0; index < arr6.length; index++) {
			System.out.println(arr6[index]); // null null null null
		}
		if(arr6[0] == null) {
			System.out.println("true");
		}
	}
}
