package com.jcfun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CommonResult
 * @Package: com.jcfun.springcloud.entities
 * @Author: jcfun
 * @Date: 2022/10/21 20:40
 * @Version: 1.0.0
 * @Description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;


    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}