package com.wang.annotation;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 13:36
 */
/*
类的三个内部注解:@Override  @Deprecated  @SuppressWarnings
 */
public class Test01 extends Object{

    public static void main(String[] args) {
        Test01 t = new Test01();
        t.test();
    }

    //@Override  重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

    //注释@Deprecated的程序元素是程序员不鼓励使用的程序元素，通常是因为它是危险的，或者因为存在更好的替代方法。
    @Deprecated
    public void test(){
        System.out.println("@Deprecated");
    }

    //@SuppressWarnings 警告镇压:表示在注释元素（以及注释元素中包含的所有程序元素）中应该抑制命名的编译器警告。
    @SuppressWarnings(value = "all")
    public void test2(){

    }
}
