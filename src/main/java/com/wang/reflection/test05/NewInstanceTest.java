package com.wang.reflection.test05;

import org.junit.Test;

import java.util.Random;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/20 10:36
 */

/*
通过反射去创建对应的运行时类的对象
 */
public class NewInstanceTest {

    @Test
    public void test01() throws IllegalAccessException, InstantiationException {

        Class clazz = Person.class;

        /*
        newInstance():调用此方法,创建对应的运行时类的对象,内部调用了运行时类的空参构造器

        要想此方法正常创建运行时类的对象,要求:
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够,通常设置为public

        在javabean中要求提供一个public的空参构造器.原因:
        1.便于通过的反射,创建运行时类的对象
        2.便于子类继承次运行时类时,默认调用super()时,保证父类有此构造器
         */
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }

    @Test
    public void test02(){

        int num = new Random().nextInt(3);//0 1 2
        String classPath = "";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.sql.Date";
                break;
            case 2:
                classPath = "com.wang.reflection.test05.Person";
        }

        try{
            Object obj = getInstance(classPath);
            System.out.println("num:" + num + ",对象:" + obj);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public Object getInstance(String classPath) throws Exception {
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }
}
