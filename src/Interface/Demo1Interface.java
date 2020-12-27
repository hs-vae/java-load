package com.hs_vae.Interface;

public class Demo1Interface {
    public static void main(String[] args) {
        //创建实现类的对象使用
        MyInterfaceAbstractImpl impl=new MyInterfaceAbstractImpl();
//      MyInterfaceAbstract my=new MyInterfaceAbstract();  错误写法,不能直接new接口对象
          impl.abs();
    }
}
