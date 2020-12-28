package com.wang.proxy;

import javax.imageio.stream.ImageInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/28 14:17
 *
 * 动态代理举例
 */
interface Human{

    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can Fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil{
    public void method1(){
        System.out.println("=============通用方法1=================");
    }

    public void method2(){
        System.out.println("=============通用方法2=================");
    }
}

/*
要想实现动态代理,需要解决的问题?
问题一:如何根据加载到内存中的被代理类,动态的创建一个代理类及其对象
问题二:当通过代理类的对象调用方法时,如何动态的去调用被代理类中的同名方法.
 */
class ProxyFactory{

    //调用此方法,返回一个代理类的对象.解决问题一
    public static Object getProxyInstance(Object obj){//obj:被代理类对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    //当我们通过代理类的对象,调用方法a时,就会自动的调用如下的放法:invoke()
    //将被代理类要执行的放法a的功能就声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        //method:即为代理类对象调用的方法,此方法也就座位了被代理类对象要调用的方法
        //obj:被代理类对象
        Object returnValue = method.invoke(obj, args);

        util.method2();

        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnValue;
    }
}
public class ProxyTest {

    public static void main(String[] args) {

        //被代理类的对象
        SuperMan superMan = new SuperMan();
        //代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        //当通过代理类对象调用方法时,会自动的调用被代理类中同名的方法
        proxyInstance.eat("炸鸡");
        System.out.println(proxyInstance.getBelief());

        System.out.println("**************************");
        //被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //代理类的对象
        ClothFactory proxyNike = (ClothFactory) ProxyFactory.getProxyInstance(nike);
        //当通过代理类对象调用方法时,会自动的调用被代理类中同名的方法
        proxyNike.produceCloth();

    }
}
