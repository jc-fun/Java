package com.supertain.exercise;

public class ArrayExercise1 {
	public static void main(String[] args) {
		// 二维数组求和
		int arr[][] = {{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j  = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println("sum is " + sum);
		System.out.println("-------------------");
		
		
		// 杨辉三角
		int[][] arr2 = new int[10][];
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = new int[i + 1];
			arr2[i][0] = arr2[i][i] = 1; // 给每行的首末值赋值为1
			// 给每行的非首末元素赋值
//			if(i > 1) {
				for(int j = 1; j < arr2[i].length - 1; j++) {
					arr2[i][j] = arr2[i-1][j-1] + arr2[i-1][j];
//				}
			}
			
		}
		for(int i = 0; i < arr2.length; i++) {
			for(int j  = 0; j < arr2[i].length; j++) {
				System.out.print(arr2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
