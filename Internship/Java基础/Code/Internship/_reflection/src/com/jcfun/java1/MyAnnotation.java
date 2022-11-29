package com.jcfun.java1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @ClassName: MyAnnotation
 * @Package: com.jcfun.java1
 * @Author: jcfun
 * @Date: 2022/11/29 上午10:25
 * @Version: 1.0.0
 * @Description: TODO
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";

}
