package com.hs_vae.Static;

public class MyClass {
    int num;
    static int numStatic;
    public void Method(){
        System.out.println("这是一个成员方法");
        System.out.println(num);
        System.out.println(numStatic);
    }
    public static void StaticMethod(){
        System.out.println("这是一个静态方法");
        System.out.println(numStatic);
        //System.out.println(num);  //不能访问非静态的成员变量
        //System.out.println(this);  //不能使用this
    }
}
