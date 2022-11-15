package com.urain.springboot.boot.config;

import ch.qos.logback.core.pattern.FormatInfo;
import com.urain.springboot.boot.bean.Car;
import com.urain.springboot.boot.bean.Pet;
import com.urain.springboot.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: urain
 * @Date: 2022/5/8 10:07
 * @Description:
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods：代理bean的方法
 *      Full（proxyBeanMethods = true）、Lite（proxyBeanMethods = false）
 *      组件依赖
 * 4.@Import({User.class, FormatInfo.class})
 *      给容器中自动创建出这两个类型的组件，默认组件的名字就是全类名
 *
 * 5.@ImportResource("classpath:beans.xml")
 *      导入Spring的配置文件
 * @Version: 1.0
 */

@Import({User.class, FormatInfo.class})
@Configuration(proxyBeanMethods = false) // 告诉SpringBoot这是一个配置类 == 配置文件
// @ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
// @ImportResource("classpath:beans.xml")  // 导入配置文件的配置
@EnableConfigurationProperties(Car.class)  // 1.开启Car的配置绑定功能  2.把Car组件自动注册到容器中
public class MyConfig {

    /**
     * @Author: urain
     * @Date: 2022/5/8 10:37
     * @Description: 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @Version: 1.0
    */
    //@ConditionalOnBean(name = "tom")
    @Bean // 给容器中添加组件，以方法名作为组件的id，返回类型就算是组件类型，返回的值就是组件在容器中的实例
    public User user01() {
        User zhangsan = new User("张三", 18);
        // user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    //@Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }

}
