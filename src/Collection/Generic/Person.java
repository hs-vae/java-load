package com.hs_vae.Collection.Generic;
/*
    定义一个含有泛型的类,模拟ArrayList集合
    泛型可以接收任意的数据类型,比如Integer,com.hs_vae.String,Person...
    创建对象时候确定泛型的类型
 */
public class Person<E> {
    private E name;

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }
}
