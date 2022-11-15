package com.jcfun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName: Payment
 * @Package: com.jcfun.springcloud.entities
 * @Author: jcfun
 * @Date: 2022/10/21 20:39
 * @Version: 1.0.0
 * @Description: TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private Long id;
    private String serial;


}

