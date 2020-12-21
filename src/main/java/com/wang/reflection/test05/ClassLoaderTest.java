package com.wang.reflection.test05;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/18 10:54
 */
public class ClassLoaderTest {

    @Test
    public void test01(){
        //对于自定义类,使用系统类加载器
        ClassLoader cl1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(cl1);
        //调用系统类加载器的getParent(),获取扩展类加载器
        ClassLoader cl2 = cl1.getParent();
        System.out.println(cl2);
        //调用扩展类加载器的getParent(),无法获取引导类加载器
        //引导类加载器主要负责java的核心类库,无法加载自定义类
        ClassLoader cl3 = cl2.getParent();
        System.out.println(cl3);
    }

    /*
    Properties:用来读取配置文件
     */
    @Test
    public void test02() throws Exception {
        Properties pro = new Properties();
        //此时的文件默认在当前的Module下.

        //读取配置文件的方式一:
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pro.load(fis);

        //读取配置文件的方式二:使用ClassLoader
        //配置文件默认识别位置是 resources 目录下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pro.load(is);

        System.out.println(pro.getProperty("user"));
        System.out.println(pro.getProperty("password"));
    }
}
