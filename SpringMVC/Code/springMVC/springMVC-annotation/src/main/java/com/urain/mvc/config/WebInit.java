package com.urain.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author: urain
 * @date: 2022/4/28 15:19
 * @description:
 * @version: 1.0
 */
// web工程的初始化类，用来代替web.xml
public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * @author: urain
     * @date: 2022/4/28 15:21
     * @description: 指定spring的配置类
     * @version: 1.0
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * @author: urain
     * @date: 2022/4/28 15:22
     * @description: 指定springMVC的配置类
     * @version: 1.0
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /**
     * @author: urain
     * @date: 2022/4/28 15:22
     * @description: 指定DispatcherServlet的映射规则，即url-pattern
     * @version: 1.0
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * @author: urain
     * @date: 2022/4/28 15:33
     * @description: 注册过滤器
     * @version: 1.0
    */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{hiddenHttpMethodFilter, characterEncodingFilter};
    }

}
