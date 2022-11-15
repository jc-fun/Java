package com.supertain.exer;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: supertain
 * @Date: 2022/2/16 18:40
 * @Description:
 */
public class Exer {
    @Test
    public void exerFun() {
        List list = new ArrayList();
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 10; i++) {
            System.out.print("请输入：");
            int num = scan.nextInt();
            list.add(num);
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                    Integer n1 = (Integer)o1;
                    Integer n2 = (Integer)o2;
                    return -Integer.compare(n1, n2);
            }
        });
        System.out.println(list);
    }

}
