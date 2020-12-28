package com.wang.reflection.test06.Test;

import com.wang.reflection.test06.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/23 15:17
 */
public class OtherTest {

    /*
    获取构造器
     */
    @Test
    public void test01(){
        Class<Person> clazz = Person.class;

        //getConstructors():获取当前运行时类中声明为public访问权限的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        //getDeclaredConstructors():获取当前运行时类中声明的所有构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test02(){
        Class<Person> clazz = Person.class;

        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
    获取运行时类的带泛型的父类
     */
    @Test
    public void test03(){
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    /*
    获取运行时类的带泛型的父类的泛型
     */
    @Test
    public void test04(){
        Class<Person> clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    /*
    获取运行时类实现的接口
     */
    @Test
    public void test05(){
        Class<Person> clazz = Person.class;

        //getInterfaces():获取当前运行时类的接口(不包含父类的接口)
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        System.out.println();

        //先获取父类,在获取父类的接口
        Class<? super Person> superclass = clazz.getSuperclass();
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    /*
    获取运行时类所在的包
     */
    @Test
    public void test06(){
        Class<Person> clazz = Person.class;

        //getPackage():获取当前运行时类所在的包
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);

    }

    /*
    获取运行时类声明的注解
     */
    @Test
    public void test07(){
        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
