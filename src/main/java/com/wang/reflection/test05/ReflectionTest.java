package com.wang.reflection.test05;



import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 21:53
 */
/*
疑问1:通过直接new的方式或反射的方式都可以调用公共的结构,开发中到底是用哪个?
建议:直接new的方式

疑问2:什么时候会用反射的方式?
答:反射的特征是动态性,需要用到动态性的时候使用反射

疑问3:反射机制与面向对象中的封装性是不是矛盾?如何看待两个技术?
答:不矛盾.
 */

public class ReflectionTest {

    //反射之前对于Person类的操作
    @Test
    public void test01(){
        //1.创建Person对象
        Person p1 = new Person("小王",17);

        //2.通过对象,调用其内部的属性/方法
        p1.age = 23;
        System.out.println(p1.toString());

        p1.show();
        p1.say("I Love You");

        //在Person类外部,不可以通过Person类的对象调用其内部私有结构.
        //比如name , showNation() 以及私有的构造器
    }

    //反射之后,对于Person的操作
    @Test
    public void test02() throws Exception{
        Class clazz = Person.class;
        //1. 通过反射,去新建一个对象
        //1.1 获取构造器(根据构造器的形参,来获取不同重载的构造器)
        Constructor cons = clazz.getConstructor(String.class, Integer.class);
        //1.2 通过构造器去新建一个Person对象
        Object obj = cons.newInstance("小明", 17);
        Person person = (Person) obj;
        System.out.println(person.toString());

        //2. 通过反射,调用对象指定的属性,方法
        //2.1 获取类中的属性:通过属性名来获取
        Field age = clazz.getDeclaredField("age");
        //2.2 给指定对象(person)的属性进行赋值
        age.set(person,22);
        System.out.println(person.toString());

        //2.3 获取类中的方法:通过方法名和此方法的形参类型去获取(如果是空参,则不需要输入形参类型)
        Method show = clazz.getDeclaredMethod("show");
        Method say = clazz.getDeclaredMethod("say", String.class);
        //2.4 通过invoke()调用获取到的方法(空参不用赋值,有形参需要赋值)
        show.invoke(person);
        say.invoke(person,"I Love You");

        //3. 通过反射,调用Person类的私有构造器,方法和属性
        //3.1 获取构造器(根据构造器的形参,来获取不同重载的构造器)
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        //3.2 通过构造器去新建一个Person对象
        Person person2 = (Person) cons1.newInstance("小小王");
        System.out.println(person2.toString());
        //3.3 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person2,"王德发");
        System.out.println(person2);
        //3.4 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String china = (String) showNation.invoke(person2,"China"); //相当于person2.showNation("China")
        System.out.println(china);
    }
    /*
    关于java.lang.Class类的理解
    1.类的加载过程:
    程序经过javac.exe命令以后,会生成一个或多个字节码文件(.class结尾).
    接着我们使用java.exe命令对某个字节码文件进行解释运行,相当于将某个字节码文件加载到内存中,此过程称为类的加载
    加载到内存中的类,我们称为运行时类,此运行时类,就作为Class的一个实例.

    2.换而言之,Class的实例就对应着一个运行时类
    3.加载到内存中的运行时类,会缓存一定时间,在此时间内,可以通过不同的方式来获取此运行时类
     */

}
