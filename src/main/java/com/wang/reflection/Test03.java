package com.wang.reflection;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 20:36
 */
/*
获取Class的实例的方式(前三种方式需要掌握)
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {

        //方式一:通过调用运行时类的属性: .class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式二:通过运行时类的对象,调用 getClass()
        Person s = new Student();
        Class c1 = s.getClass();
        System.out.println(c1.hashCode());

        //方拾三:调用Class的静态方法: forName获得 (String classPath) (最常用)
        Class c2 = Class.forName("com.wang.reflection.Student");
        System.out.println(c2.hashCode());

        //方式四:使用类的加载器:ClassLoader   (了解)
        ClassLoader classLoader = Test03.class.getClassLoader();
        Class c4 = classLoader.loadClass("com.wang.reflection.Student");
        System.out.println(c4.hashCode());

//        //方式五:基本内置类型的包装类都有一个Type属性
//        Class c5 = Integer.TYPE;
//        System.out.println(c4);
//
//        //方式六:获取父类类型
//        Class c6 = c1.getSuperclass();
//        System.out.println(c5);
    }
}

class Person{
    public String name;
    public Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student extends Person{
    public Integer studentId;

    public Student(){
        this.name = "小学生";
    }
}

class Teacher extends Person{
    public Integer teacherId;

    public Teacher(){
        this.name = "中学老师";
    }
}