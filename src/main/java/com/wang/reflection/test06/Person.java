package com.wang.reflection.test06;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/21 20:20
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface{

    public String name;
    int age;
    private int id;

    public Person(){}

    @MyAnnotation("abc")
    public Person(String name){
        this.name = name;
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是:" + nation);
        return nation;
    }

    public String display(String interest){
        return interest;
    }

    @Override
    public void info() {
        System.out.println("I'm Human!");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}