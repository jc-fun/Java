package com.urain.myssm.listeners;

import com.urain.myssm.ioc.BeanFactory;
import com.urain.myssm.ioc.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author: supertain
 * @Date: 2022/4/11 9:09
 * @Description:
 */

//监听上下文启动，在上下文启动的时候去创建IOC容器,然后将其保存到application作用域
//后面中央控制器再从application作用域中去获取IOC容器
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        String path = application.getInitParameter("contextConfigLocation");
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(path);
        application.setAttribute("beanFactory", beanFactory);
    }
}
