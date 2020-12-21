package com.wang.reflection.test06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/21 20:51
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String value() default "hello";
}
