package com.hs_vae.Extends.Demo6;
/*
       super关键字用来访问父类内容,而this关键字用来访问本类内容.用法也有三种
       1.在本类的成员方法中,访问本类的成员变量
       2.在本类的成员方法中,访问本类的另一个成员方法
       3.在本类的构造方法中,访问本类的另一个构造方法
       第三种方法注意:
                 a.this(...)调用也必须是构造方法的第一个语句,唯一一个.
                 b.super和this两种构造调用,不能同时使用
 */
public class Fu {
    int num=10;
    public void method(){
        System.out.println("父类的成员方法");
    }
}
