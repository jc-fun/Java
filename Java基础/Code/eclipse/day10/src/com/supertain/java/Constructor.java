package com.supertain.java;

/*
 * 类的结构之三: 构造器(或构造方法/constructor)的使用
 * 
 * 作用: 
 * 	> 创建对象
 *  > 初始化对象的信息
 * 
 * 说明: 
 * 	> 1.如果没有显式的定义类的构造器的话,则系统默认提供一个空参的构造器(权限默认与类相同)
 * 	> 2.格式: 权限修饰符 类名(形参列表){}
 * 	> 3.若一个类中定义多个构造器,则它们彼此构成重载
 * 	> 4.一旦我们显式的定义了类的构造器之后,系统就不再提供默认的空参构造器
 * 	> 5.一个类中至少会有一个构造器
 * 
 * 属性赋值的方法: 
 * 	> 1.默认初始化值
 *  > 2.显式初始化
 *  > 3.构造器中赋值
 *  > 4.通过"对象.方法", 或"对象.属性"的方式赋值
 *  先后顺序: 1 - 2 - 3 - 4
 */

public class Constructor {
	public static void main(String[] args) {
		// 创建类的对象: new + 构造器
//		Person p = new Person();
//		p.eat();
		Person p = new Person("Tom");
		System.out.println(p.name);
	}
}

class Person {
	// 属性
	String name;
	int age;
	
	// 方法
	public void eat() {
		System.out.println("吃饭");
	}
	
	// 构造器
	public Person() {
		age = 18;
		System.out.println("constructor");
	}
	public Person(String arg) {
		name = arg;
	}
}