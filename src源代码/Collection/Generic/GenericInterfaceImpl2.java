package com.hs_vae.Collection.Generic;
/*
    含有泛型的接口第二种使用方式:
    接口使用什么泛型,实现类就是用什么泛型,类跟着接口走
    相当于定义了一个含有泛型的类,创建对象时候确定泛型的类型
 */
public class GenericInterfaceImpl2<M> implements GenericInterface<M> {
    @Override
    public void method(M m) {
        System.out.println(m);
    }
}
