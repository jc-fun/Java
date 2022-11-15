package com.urain.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Boot05WebAdminApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Boot05WebAdminApplication.class, args);
        for (String beanDefinitionName : run.getBeanDefinitionNames()) {

            System.out.println(beanDefinitionName);
        }


    }

}
