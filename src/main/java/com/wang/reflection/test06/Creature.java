package com.wang.reflection.test06;

import java.io.Serializable;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/21 20:10
 */
public class Creature<T> implements Serializable {

    public char gender;
    private double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物进食");
    }

}
