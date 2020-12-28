package com.wang.reflection.test06.Test;

import com.wang.reflection.test06.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/23 14:45
 *
 * 获取运行时类的方法结构
 */
public class MethodTest {

    @Test
    public void test01(){
        Class<Person> clazz = Person.class;

        //getMethods():获取当前运行时类及其父类中声明为public访问权限的方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        //getDeclaredMethods():获取当前运行时类中声明的所有方法.(不包含父类中声明的方法)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

}
