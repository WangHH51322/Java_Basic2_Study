package com.wang.reflection;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 20:24
 */
/*
什么叫反射
 */
public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射获取类的Class对象
        Class c1 = Class.forName("com.wang.reflection.User");
        System.out.println(c1);

        Class c2 = Class.forName("com.wang.reflection.User");
        Class c3 = Class.forName("com.wang.reflection.User");
        Class c4 = Class.forName("com.wang.reflection.User");

        //一个类在内存中只有一个Class对象:c2.hashCode() = c3.hashCode() = c4.hashCode()
        //一个类被加载后,类的整个结构都会被封装在Class对象中
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());
    }
}

//实体类:pojo  entity
class User{

    private String name;
    private Integer age;
    private Integer id;

    public User() {
    }

    public User(String name, Integer age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
