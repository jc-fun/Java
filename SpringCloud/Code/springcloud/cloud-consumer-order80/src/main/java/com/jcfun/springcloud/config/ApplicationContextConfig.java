package com.jcfun.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName: ApplicationContextConfig
 * @Package: com.jcfun.springcloud.config
 * @Author: jcfun
 * @Date: 2022/10/21 20:46
 * @Version: 1.0.0
 * @Description: TODO
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
