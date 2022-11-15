package com.urain.myssm.util;

/**
 * @Author: supertain
 * @Date: 2022/4/7 16:56
 * @Description:
 */
public class StringUtil {
    // 判断字符串是否为null或为""
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
}
