package com.hs_vae.Interface;
/*
     1.接口的默认方法,可以通过接口实现类通过继承直接调用
     2.接口的默认方法,也可以被接口实现类进行覆盖重写,一旦被覆盖重写,那么就改变了默认方法
 */
public class Demo2Interface {
    public static void main(String[] args) {
        MyInterfaceDefaultA a=new MyInterfaceDefaultA();
        a.def();   //这是接口的默认方法
        MyInterfaceDefaultB b=new MyInterfaceDefaultB();
        b.def();   //这是覆盖重写的默认方法
    }
}
