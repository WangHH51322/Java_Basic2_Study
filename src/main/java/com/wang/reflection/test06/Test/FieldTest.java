package com.wang.reflection.test06.Test;

import com.wang.reflection.test06.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/21 20:57
 *
 * 获取运行时类的属性结构
 */
public class FieldTest {

    @Test
    public void test01(){
        Class<Person> clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println();

        //getDeclaredFields():获取当前运行时类中声明的所有属性.(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    //获取属性的权限修饰符  数据类型  变量名
    @Test
    public void test02(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1.权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //2.数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");

            //3.变量名
            String name = declaredField.getName();
            System.out.print(name);

            System.out.println();
        }
    }
}
