package com.hs_vae.Extends.Demo1;

public class Zi extends Fu{
    int num=20;
    public void method(){
        int num=30;
        System.out.println(num);        //访问局部变量
        System.out.println(this.num);   //访问本类的成员变量
        System.out.println(super.num);  //访问父类的成员变量
    }
}
