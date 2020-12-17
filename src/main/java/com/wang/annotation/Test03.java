package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 14:06
 */
/*
自定义注解
 */
public class Test03 {

    @MyAnnotation2(age = 23)    //注解可以显式赋值,如果没有默认值,则必须给注解赋值
    public void test(){}

    @MyAnnotation3("小王")    //如果注解里面只有一个参数,可以将参数命名为value,并且显式赋值的时候,不需要加参数名直接复制
    public void test2(){}

}

@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数 : 参数类型+参数名()
    String name() default "小王";
    int age();
    int id() default -1;    //如果默认值为-1,代表不存在
    String[] schools() default {"西安石油大学","中国石油大学"};
}

@Target(value = {ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    //注解的参数 : 参数类型+参数名()
    String value();
}
