package com.urain.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: urain
 * @date: 2022/4/23 23:54
 * @description:
 * @version: 1.0
 */
@Configuration // 作为配置类，替代xml配置文件
@ComponentScan(basePackages = {"com.urain"})
public class SpringConfig {

}
