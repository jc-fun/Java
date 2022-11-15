/*
break 和 continue关键字
                使用范围              作用
    break       switch-case结构中    跳出程序
                循环结构中           结束当前循环
    continue    循环结构中           结束当次循环
 */

class SpecialKeywords {
  public static void main(String [] args) {
    // for (int i = 1; i <= 10; i++) {
    //   if(i % 4 == 0) {
    //     // break; //123
    //     continue; //123567910
    //   }
    //   System.out.println(i);
    // }

    System.out.println();
    label:for (int i = 1; i < 10; i++) {
      for (int j = 11; j < 20; j++) {
        if(j % 4 == 0) {
          // break;  //默认结束包裹此关键字的最近的一层循环
          break label; //结束指定标识的一层循环
          // continue 同理
        }
        System.out.println("j的值为" + j);
      }
      System.out.println("i的值为" + i);

    }
  }
}
