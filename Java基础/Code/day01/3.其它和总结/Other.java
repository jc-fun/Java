/*
1.在一个java源文件中可以声明多个class。但是，只能最多有一个类声明为public的。
而且要求声明为public的类名必须于源文件名相同
2.程序的入口是main()方法，格式是固定的。
3.编译的过程：编译以后，会生成一个或多个字节码文文件。字节码文件的文件名与java源文件中的类名相同。
*/
// public class other {
// 	public static void main(String[] args) {  //public static void main(String a[]) args:arguments
// 		System.out.println("this is a conclusion");
// 	}
// }
class Person {

}
class Animal {

}

public class Other {
    public static void main(String[] args) {
        // String str = new String();
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
            // str += args[i];
        }
        // System.out.println(str);
    }
}

/*
	1.public关键字,声明主函数为public就是告诉其他的类可以访问这个函数。
	2.static关键字，告知编译器main函数是一个静态函数。
	也就是说main函数中的代码是存储在静态存储区的，即当定义了类以后这段代码就已经存在了。
	如果main()方法没有使用static修饰符，那么编译不会出错，但是如果你试图执行该程序将会报错，提示main()方法不存在。
	因为包含main()的类并没有实例化（即没有这个类的对象），所以其main()方法也不会存。
	而使用static修饰符则表示该方法是静态的，不需要实例化即可使用。
	3.void关键字表明main()的返回值是无类型。
	4.参数String[] args。
		1)程序使用者可以在命令行状态下向某个类传递参数。
		2)正常函数传参
*/
