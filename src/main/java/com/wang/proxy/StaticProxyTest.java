package com.wang.proxy;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/12/27 21:48
 *
 * 静态代理实例
 *
 * 特点:代理类和被代理类在编译期间,就确定下来了
 */
interface ClothFactory{

    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{

    private ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory){
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("开始生产衣服");

        clothFactory.produceCloth();

        System.out.println("结束生产衣服");
    }
}

//被代理类
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("生产Nike品牌的衣服");
    }
}

public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //常见代理类的对象
        ProxyClothFactory clothFactory = new ProxyClothFactory(nike);

        clothFactory.produceCloth();
    }
}
