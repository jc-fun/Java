package com.urain.securitydemo1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Author: urain
 * @Date: 2022/5/14 22:25
 * @Description:
 * @Version: 1.0
 */
@Configuration
// @EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    // 注入数据源
    @Resource
    private DataSource dataSource;

    // 配置对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 退出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();

        // 配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin()  // 自定义自己编写的登录页面
            .loginPage("/login.html")  // 登录页面设置
            .loginProcessingUrl("/user/login")  // 登录访问路径
            .defaultSuccessUrl("/success.html").permitAll()  // 登录成功之后，跳转路径
            .and().authorizeRequests()
            .antMatchers("/", "/test/hello", "/user/login").permitAll()  // 设置哪些路径可以直接访问，不需要认证
            //.antMatchers("/test/index").hasAuthority("admins")  // 当前登录用户具有admins权限才可以访问/test/index，只能针对单一权限设置
            // .antMatchers("/test/index").hasAnyAuthority("admins", "manager")  //针对多项权限设置
            .antMatchers("/test/index").hasRole("sale")
            .anyRequest().authenticated()
            .and().rememberMe().tokenRepository(persistentTokenRepository())
            .tokenValiditySeconds(60)  // 设置有效时长
            .userDetailsService(userDetailsService)
            .and().csrf().disable();  //关闭csrf防护
    }
}
