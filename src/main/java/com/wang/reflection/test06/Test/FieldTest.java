package com.wang.reflection.test06.Test;

import com.wang.reflection.test06.Person;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/21 20:57
 */
public class FieldTest {

    @Test
    public void test01(){
        Class<Person> clazz = Person.class;

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
    }
}
