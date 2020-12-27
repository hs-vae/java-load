package com.hs_vae.Collection.Generic;
/*
    含有泛型的接口,第一种使用方式:
    定义接口的实现类,实现接口,指定接口的泛型
 */
public class GenericInterfaceImpl1 implements GenericInterface<Integer>{
    @Override
    public void method(Integer integer) {
        System.out.println(2);
    }
}
