package com.supertain.overwrite;

public class Person {
	String name;
	int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("吃饭");
	}
	void walk(int distance) {
		System.out.println("走路,走得距离是: " + distance + "km");
	}
	private void show() {
		System.out.println("我是一个人");
	}
	public Object info() {
		return null;
	}
}
