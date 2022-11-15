/*
1.%取余（取模）
结果的符号与被模数的符号相同
2.++ -- +=...不会改变变量本身的数据类型（例如short s；可以写成s++而不会有类型提升的问题）
3.逻辑运算符：
  & | ! 逻辑与或非
  && || 短路与或
  ^ 逻辑异或
  & 和 && 的作用是相同的，即运算结果相同。当符号左边为true时，二者都会执行符号右边的运算；当符号左边是false
  时，&继续执行符号右边的运算，&&不再执行符号右边的运算（即右边"被短路了"）
  | 和 || 同理，左边为 true 时短路
 */



public class Operator {
  public static void main(String[] args) {
    // boolean a = true;
    boolean a = false;
    int b = 10;
    if(a && (b++ > 0)) {
      System.out.println("is true");
    }else {
      System.out.println("is false");
    }
    System.out.println(b);
    //-------------------------------
    if(a & (b++ > 0)) {
      System.out.println("is true");
    }else {
      System.out.println("is false");
    }
    System.out.println(b);

    byte c = -127;
    System.out.println((byte)(c << 1));
  }
}
