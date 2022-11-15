package com.supertain.overwrite;

public class Student extends Person {
	String major;
	
	public Student() {
		
	}
	public Student(String major) {
		this.major = major;
	}
	
	public void study() {
		System.out.println("学习,专业是: " + major);
	}
	// 对父类中的eat方法进行了重写
	public void eat() {
		System.out.println("学生应该多吃有营养的食物");
	}
	// 无法对父类中声明为private的方法进行重写
	public void show() {
		System.out.println("我是一个学生");
	}
	// 返回值类型为子类也可以构成重写
	public String info() {
		return null;
	}
}
