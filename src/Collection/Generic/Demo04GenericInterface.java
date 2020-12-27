package com.hs_vae.Collection.Generic;
/*
    测试含有泛型的接口
 */
public class Demo04GenericInterface {
    public static void main(String[] args) {
        //创建GenericInterfaceImpl1对象
        GenericInterfaceImpl1 g1=new GenericInterfaceImpl1();
        g1.method(1);
        //创建GenericInterfaceImpl2对象,泛型为String
        GenericInterfaceImpl2<String> g2=new GenericInterfaceImpl2<>();
        g2.method("许嵩");
        //创建GenericInterfaceImpl2对象,泛型为Double
        GenericInterfaceImpl2<Double> g3 = new GenericInterfaceImpl2<>();
        g3.method(1.01);
    }
}
