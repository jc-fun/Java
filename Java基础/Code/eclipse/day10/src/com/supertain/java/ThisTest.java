package com.supertain.java;

/*
 * this关键字的使用:
 * 	> this可以用来修饰属性、方法和构造器
 * 		> this修饰属性和方法: this理解为当前对象
 * 		> this修饰构造器: this理解为当前正在创建的对象
 * 	> this调用构造器
 * 		> 我们在类的构造器中,可以显式的使用"this(形参列表)"方式,调用本类中指定的其它构造器
 * 		> 构造器中不能通过"this(形参列表)"方式调用自己
 * 		> 为了防止循环调用,如果一个类中有n个构造器,则最多有n - 1个构造器中使用了"this(形参列表)"
 * 		> 规定: "this(形参列表)"必须生命在当前构造器的首行
 * 		> 构造器内部,最多只能声明一个"this(形参列表)",用来调用其它的构造器
 */

public class ThisTest {
	public static void main(String[] args) {
		NewPerson p = new NewPerson();
		p.setAge(18);
		System.out.println(p.getAge());
	}
}

class NewPerson {
	private String name;
	private int age;
	
	public NewPerson() {
		
	}
	public NewPerson(String name) {
		this();
		this.name = name;
	}
	public NewPerson(int age) {
		this();
		this.age = age;
	}
	public NewPerson(String name, int age) {
		this(age);
		this.name = name;
//		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	public void eat() {
		System.out.println("吃饭");
		this.study();
	}
	public void study() {
		System.out.println("学习");
	}
}