package com.urain.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/10 15:48
 * @Description:
 */

//@WebFilter("/demo01.do")
@WebFilter("*.do")
public class Filter01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("A1");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("A2");
    }

    @Override
    public void destroy() {

    }
}
