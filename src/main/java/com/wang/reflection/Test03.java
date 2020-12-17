package com.wang.reflection;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 20:36
 */
public class Test03 {

    public static void main(String[] args) throws ClassNotFoundException {
        Person s = new Student();

        //方式一:通过对象获得
        Class c1 = s.getClass();
        System.out.println(c1.hashCode());

        //方拾二:forName获得
        Class c2 = Class.forName("com.wang.reflection.Student");
        System.out.println(c2.hashCode());

        //方式三:通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //方式四:基本内置类型的包装类都有一个Type属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //方式五:获取父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
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