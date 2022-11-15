package com.urain.springboot.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: urain
 * @Date: 2022/5/7 18:17
 * @Description:
 * @Version: 1.0
 */
// @SpringBootApplication：这是一个SpringBoot应用
// 主程序类、主配置类
@SpringBootApplication(scanBasePackages = "com.urain.springboot")  // 可以设置扫描的基础路径
// 下面三个注解等同于@SpringBootApplication
// @SpringBootConfiguration
// @EnableAutoConfiguration
// @ComponentScan("com.urain.springboot")  // 设置扫描路径
public class MainApplication {

    public static void main(String[] args) {
        // 1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2.查看容器中的组件
        // String[] beanDefinitionNames = run.getBeanDefinitionNames();
        // for (String beanDefinitionName : beanDefinitionNames) {
        //     System.out.println(beanDefinitionName);
        // }

        // 从容器中获取组件
        // Pet tom = run.getBean("tom", Pet.class);
        //
        // Pet tom1 = run.getBean("tom", Pet.class);
        // System.out.println("组件: " + (tom == tom1));
        //
        // // com.urain.springboot.boot.config.MyConfig$$EnhancerBySpringCGLIB$$85a55e0b@65eb76cd
        // MyConfig bean = run.getBean(MyConfig.class);
        // System.out.println(bean);
        //
        // // 如果@Configuration(proxyBeanMethods = true)代理对象调用方法，SpringBot总会检查这个组件在容器中是否存在
        // // 保持组件单实例
        // User user1 = bean.user01();
        // User user2 = bean.user01();
        // System.out.println(user1 == user2);
        //
        // User user01 = run.getBean("user01", User.class);
        // Pet tom2 = run.getBean("tom", Pet.class);
        // System.out.println("用户的宠物:" + (user01.getPet() == tom2));
        //
        //
        // // 获取组件
        // String[] users = run.getBeanNamesForType(User.class);
        // System.out.println("========================");
        // for(String user : users) {
        //     System.out.println(user);
        // }
        // FormatInfo bean1 = run.getBean(FormatInfo.class);
        // System.out.println(bean1);


        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件：" + tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中Tom组件：" + user01);

    }

}
