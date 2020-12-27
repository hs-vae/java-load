package com.hs_vae.Polymorphism.Demo2;
/*
    访问成员变量的两种方式:
    1.直接通过对象名称访问成员变量，看等号左边是谁，优先用谁，没有则向上找
    2.间接通过成员方法访问成员变量，看该方法属于谁，优先用谁，没有则向上找
 */
public class Demo1 {
    public static void main(String[] args) {
        Fu vae =new Zi();
        System.out.println(vae.num);
        vae.method();
    }
}

