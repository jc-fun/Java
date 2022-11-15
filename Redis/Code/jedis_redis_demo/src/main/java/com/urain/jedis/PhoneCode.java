package com.urain.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @Author: urain
 * @Date: 2022/5/1 11:42
 * @Description:
 * @Version: 1.0
 */

public class PhoneCode {
    public static void main(String[] args) {
        // 模拟验证码发送
        //sendCode("13245455155");
        verifyCode("13245455155", "307046");

    }

    // 1.生成6位数字验证码
    public static String getCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for(int i = 0; i < 6; i++) {
            int rand = random.nextInt(10);
            code.append(rand);
        }
        return code.toString();
    }

    // 2.每个手机每天只能发送三次，验证码放到redis中，设置过期时间
    public static void sendCode(String phone) {
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        // 拼接key
        // 手机发送次数key
        String countKey = "VerifyCode" + phone + ":count";
        // 验证码key
        String codeKey = "VerifyCode" + phone + ":code";

        // 每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if(count == null) {
            // 第一次发送
            jedis.setex(countKey, 24 * 60 * 60, "1");
        }else if(Integer.parseInt(count) <= 2) {
            // 发送次数+1
            jedis.incr(countKey);
        } else if(Integer.parseInt(count) > 2) {
            // 发送次数超过3次
            System.out.println("今天发送次数已超过三次");
            jedis.close();
            return;
        }

        // 发送验证码放到redis中
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        System.out.println("发送成功，验证码为：" + vcode);
        jedis.close();
    }


    // 3.验证码校验
    public static void verifyCode(String phone, String code) {
        // 从redis中获取验证码
        Jedis jedis = new Jedis("192.168.188.202", 6379);
        // 验证码key
        String codeKey = "VerifyCode" + phone + ":code";
        String redisCode = jedis.get(codeKey);
        // 判断
        if(code.equals(redisCode)) {
            System.out.println("success");
        } else {
            System.out.println("failure");
        }
        jedis.close();
    }

}
