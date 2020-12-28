package com.wang.reflection.test06.Test;

import com.wang.reflection.test06.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/23 15:50
 *
 * 调用运行时类中指定的结构:属性  方法  构造器
 */
public class ReflectionTest {

    @Test
    public void test01() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();

        //获取指定的属性:要求运行时类的属性声明为public(此方法通常不适用)
        Field name = clazz.getField("name");

        /*
        设置当前属性的值

        set():参数1:指明设置那个对象的属性   参数2:将此属性值设置为多少
         */
        name.set(person,"小王");

        String pName = (String) name.get(person);
        System.out.println(pName);
    }

    /*
    如何操作运行时类中的指定的属性  -- 需要掌握
     */
    @Test
    public void test02() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = clazz.newInstance();

        //1. getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field id = clazz.getDeclaredField("id");

        //2. 保证当前属性是可访问的
        id.setAccessible(true);

        //3. 获取 设置指定对象的属性值
        id.set(person,17);
        int pId = (int) id.get(person);
        System.out.println(pId);
    }

    /*
    如何操作运行时类中的指定的构造器
     */
    @Test
    public void test03() throws Exception {
        Class<Person> clazz = Person.class;

        /*
        1.获取指定的构造器
        getDeclaredConstructor():参数:致命构造起的参数列表
         */
        Constructor<Person> constructor = clazz.getDeclaredConstructor(int.class);

        //2.保证此构造器是可访问的
        constructor.setAccessible(true);

        //3.调用此构造器,创建运行时类的对象
        Person person = constructor.newInstance(12);
        System.out.println(person);
    }
}


















