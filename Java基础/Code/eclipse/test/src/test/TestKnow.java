package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

public class TestKnow {
	@Test
  public void exerFun() {
      List list = new ArrayList();
      Scanner scan = new Scanner(System.in);
      for(int i = 0; i < 10; i++) {
          System.out.println("请输入：");
          int num = scan.nextInt();
          list.add(num);
      }
      Collections.sort(list);
      System.out.println(list);
  }
}

