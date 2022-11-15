package com.supertain.exercise;

public class ArrayExercise2 {
	public static void main(String[] args) {
		String[] arr = {"AA", "BB", "CC"};
		// 线性查找
		String dest = "DD";
		int i;
		for(i = 0; i < arr.length; i++) {
			if(dest.equals(arr[i])) {
				System.out.println("索引为:" + i);
				break;
			}
		}
		if(i > arr.length - 1) System.out.println("没有该元素");
		System.out.println("---------------------");
		
		// 二分法查找
		// 前提，所要查找的数组必须有序
		int[] arr2 = new int[] {-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
		int dest1 = -34;
		int head  = 0; // 初始首索引
		int end = arr2.length - 1; // 初始的末索引
		boolean flag = true;
		while(head < end) {
			int middle = (head + end) / 2;
			if(arr2[middle] == dest1) {
				System.out.println("索引为:" + middle);
				flag = false;
				break;
			}else if (arr2[middle] > dest1) {
				end = middle - 1;
			}else {
				head = middle + 1;
			}
		}
		if(flag) System.out.println("没有该元素");
		
	}
}
