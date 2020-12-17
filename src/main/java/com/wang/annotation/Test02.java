package com.wang.annotation;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 13:52
 */
/*
测试 元注解
 */
public class Test02 {

    @MyAnnotation
    public void test(){

    }
}

/*
自定义一个注解
 */
@Target(value= {ElementType.TYPE,ElementType.METHOD}) //@Target 表示注解的适用范围
@Retention(value = RetentionPolicy.RUNTIME)  //@Retention 表示注解在什么地方有效(RUNTIME > CLASS > SOURCE)
@Documented //表示是否将我们的注解生成在Javadoc中
@Inherited  //表示子类可以继承父类的注解
@interface MyAnnotation{

}
