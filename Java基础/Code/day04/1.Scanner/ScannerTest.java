/*
使用Scanner类获取键盘的值
  1.导包 import java.util.Scanner;
  2.Scanner的实例化：Scanner scan = new Scanner(System.in);
  3.调用Scanner类的相关方法（next()/nextXxx()），来获取指定类型的变量
  4.Scanner没有提供获取char类型的相关方法，只能获取一个字符串。可以使用String的char(int index)方法来获取想要的字符

 */

//1.导包
import java.util.Scanner;
public class ScannerTest {
  public static void main(String[] args) {
    //2.Scanner的实例化
    Scanner scan = new Scanner(System.in);
    //3.调用Scanner类的相关方法
    int num = scan.nextInt();
    System.out.println(num);
  }
}
