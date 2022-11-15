package com.urain.rabbitmq.springbootrabbitmq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Package: com.urain.rabbitmq.springbootrabbitmq.config
 * @Author: urain
 * @Date: 2022/9/26 21:22
 * @Version: 1.0.0
 * @Description: TODO
 */


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("webApi")
            .apiInfo(webApiInfo())
            .select()
            .build();
    }
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
            .title("rabbitmq 接口文档")
            .description("本文档描述了 rabbitmq 微服务接口定义")
            .version("1.0")
            .contact(new Contact("urain", "http://urainstat.top",
                "urianstar@gmail.com"))
            .build();
    } }