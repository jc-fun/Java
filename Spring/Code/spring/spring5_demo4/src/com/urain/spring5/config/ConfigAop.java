package com.urain.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author: urain
 * @date: 2022/4/24 16:35
 * @description:
 * @version: 1.0
 */

@Configuration
@ComponentScan(basePackages = {"com.urain"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {

}
