package com.wang.reflection.test05;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/17 21:53
 */
public class Person {

    private String name;
    public Integer age;

    public Person() {
        System.out.println("这是一个空参构造器");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void show(){
        System.out.println("我是好人");
    }

    public void say(String word){
        System.out.println("大声说出" + word);
    }

    private String showNation(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }
}
