/*
switch结构中的表达式，只能是byte、short、char、int、枚举（JDK5.0）和String(JDK7.0)类型

switch-case语句具有"跳转"的作用
当和某一个数字或者字符匹配上的时候，就会跳转到对应的入口地址处
break 也具有"跳转"的作用
当匹配对应的时候，执行"跳转"到对应的入口地址，后面就会顺着这个地址一直执行下去
 */

import java.util.Scanner;
public class SwitchCase {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("请输入值：");
    int value = scan.nextInt();
    switch(value) {
      case 0:
        System.out.println("zero");
        break;
      case 1:
        System.out.println("one");
        break;
      case 2:
        System.out.println("two");
        break;
      case 3:
        System.out.println("three");
        break;
      default:
        System.out.println("啥也不是");
    }
  }
}
