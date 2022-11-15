package com.urain.springboot.boot.config;


import com.urain.springboot.boot.bean.Pet;
import com.urain.springboot.boot.converter.AppMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.accept.ParameterContentNegotiationStrategy;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: urain
 * @Date: 2022/5/9 15:35
 * @Description:
 * @Version: 1.0
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig /*implements WebMvcConfigurer*/ {

    // 设置特殊请求的隐藏域属性名为 m
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("m");
        return hiddenHttpMethodFilter;
    }

    // 设置解析矩阵变量
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {

            /**
             *  自定义内容协商策略
             *
             */
            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                // Map<String, MediaType> mediaTypes
                Map<String, MediaType> mediaTypes = new HashMap<>();
                mediaTypes.put("json", MediaType.APPLICATION_JSON);
                mediaTypes.put("xml", MediaType.APPLICATION_ATOM_XML);
                mediaTypes.put("person", MediaType.parseMediaType("application/person"));

                // 指定支持解析哪些参数对应的哪些媒体类型
                // 设置请求参数协商策略
                ParameterContentNegotiationStrategy parameterStrategy =
                    new ParameterContentNegotiationStrategy(mediaTypes);
                // 自定义参数解析器的属性名
                parameterStrategy.setParameterName("ff");
                // 设置请求头协商策略
                HeaderContentNegotiationStrategy headerStrategy = new HeaderContentNegotiationStrategy();

                configurer.strategies(List.of(parameterStrategy, headerStrategy));
            }

            // 添加自定义MessageConverter
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new AppMessageConverter());
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 设置不移除 ; 后的内容。矩阵变量才可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            // 自定义格式转换器

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {
                    @Override
                    public Pet convert(String source) {
                        if(!StringUtils.isEmpty(source)) {
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setWeight(Double.parseDouble(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }
        };
    }

    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    //
    //     UrlPathHelper urlPathHelper = new UrlPathHelper();
    //     // 设置不移除 ; 后的内容。矩阵变量才可以生效
    //     urlPathHelper.setRemoveSemicolonContent(false);
    //     configurer.setUrlPathHelper(urlPathHelper);
    // }






}
