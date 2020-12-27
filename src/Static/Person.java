package com.hs_vae.Static;

public class Person {
    static{
        System.out.println("静态代码块执行！");
    }
    public Person(){
        System.out.println("构造方法执行");
    }
}
