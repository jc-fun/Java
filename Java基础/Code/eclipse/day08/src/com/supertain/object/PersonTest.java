package com.supertain.object;

/*
 * 属性 = 成员变量 = field = 域、字段
 * 方法 = 成员方法 = 函数 = method
 * 创建类的对象 = 类的实例化 = 实例化类
 * 
 * 属性(非static): 直接定义在类的一对{}中
 * 	>可以使用权限修饰符
 * 	>有其初始化值
 * 	>加载到堆空间
 * 局部变量: 声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
 * 	>不可以使用权限修饰符
 * 	>必须显示赋值。特别的,形参在调用时赋值即可
 * 	>加载到栈空间
 * 
 * 权限修饰符: private、public、缺省(default)、protected
 * 
 * 方法的声明: 权限修饰符 返回值类型 方法名(形参列表) {
 * 		方法体
 * }
 */

public class PersonTest {
	public static void main(String[] args) {
		
		// 创建Person类的对象
		Person p1 = new Person();
		
		// 调用对象的结构、属性、方法
		p1.name = "Tom";
		p1.IsMale = true;
		System.out.println(p1.name);
		p1.eat();
		p1.talk("Chinese");
	}
}

class Person {
	
	// 属性
	String name;
	int age;
	boolean IsMale;
	
	// 方法
	public void eat() {
		System.out.println("吃饭");
	}
	
	public void sleep() {
		System.out.println("睡觉");
	}
	
	public void talk(String language) {
		System.out.println("说的是" + language);
	}
	
}