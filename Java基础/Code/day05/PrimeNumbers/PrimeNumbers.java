// System 的 currentTimeMillis() 方法可以返回当前的时间戳类型为 long
// Math 的 sqrt() 方法可以对数字进行开方
public class PrimeNumbers {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    int count = 0;
    // boolean flag = true;
    // for(int i = 2; i <= 100000; i++) {
    //   // for(int j = 2; j < i; j++) {
    //   for(int j = 2; j <= Math.sqrt(i); j++) {
    //     if(i % j == 0) {
    //       flag = false;
    //       break;
    //     }
    //   }
    //   if(flag) {
    //     // System.out.println(i);
    //     count++;
    //   }
    //   flag = true;


    label:for(int i = 2; i <= 100000; i++) {
      for(int j = 2; j <= Math.sqrt(i); j++) {
        if(i % j == 0) {
          continue label;
        }
      }
      count++;
    }



    long endTime = System.currentTimeMillis();
    System.out.println("共有" + count + "个质数");
    System.out.println("程序运行共花费了" + (endTime - startTime) + "ms");
  }
}
