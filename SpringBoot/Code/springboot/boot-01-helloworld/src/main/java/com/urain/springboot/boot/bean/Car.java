package com.urain.springboot.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: urain
 * @Date: 2022/5/8 11:26
 * @Description:
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
//@Component
@ConfigurationProperties(prefix = "car")
public class Car {

    private String brand;
    private Integer price;

}
