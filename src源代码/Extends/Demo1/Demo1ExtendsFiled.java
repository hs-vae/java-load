package com.hs_vae.Extends.Demo1;
/*
       区分子类方法中重名的三种变量:

       1.局部变量: 直接写成员变量名
       2.本类的成员变量: this.成员变量名
       3.父类的成员变量: super.成员变量名
 */
public class Demo1ExtendsFiled {
    public static void main(String[] args) {
        Zi zi=new Zi();
        zi.method();   //输出30 20 10
    }
}
