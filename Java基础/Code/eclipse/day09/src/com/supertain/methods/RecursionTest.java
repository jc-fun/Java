package com.supertain.methods;

/*
 * 递归方法的使用
 * 1.递归方法: 一个方法体内调用它自身
 * 2.方法递归包含了一种隐式循环，它会重复执行某段代码，但这种重复执行无须循环控制
 * 3.递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环
 * 
 */

public class RecursionTest {
	
	public static void main(String[] args) {
		// 计算1-100之间所有自然数的和
//		int sum = 0;
//		for(int i = 0; i <= 100; i++) {
//			sum += i;
//		}
		
		
		RecursionTest test = new RecursionTest();
		int sum = test.getSum(100);
		System.out.println(sum);
		int value = test.evaluation(10);
		System.out.println(value);
		int fibonacci = test.fibonacciSequence(10);
		System.out.println(fibonacci);
		float hanoi = test.towerOfHanoi(64);
		System.out.println(hanoi);
	}
	
	
	public int getSum(int n) {
		return n == 1 ? 1 : n + getSum(n - 1);
	}
	
	
	// 已知有一个数列: f(0) = 1, f(1) = 4; f(n + 2) = 2 * f(n + 1) + f(n); 其中n是大于0的整数，求f(10)的值
	public int evaluation(int n) {
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return 4;
		}else {
			return 2 * evaluation(n - 1) + evaluation(n - 2);
		}
	}
	
	// 斐波那契数列
	public int fibonacciSequence(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
		}
	}
	
	// 汉诺塔
	public float towerOfHanoi(float n) {
		return n == 0 ? 0 : towerOfHanoi(n - 1) * 2 + 1;
	}
	
}
