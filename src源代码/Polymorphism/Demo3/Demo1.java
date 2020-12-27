package com.hs_vae.Polymorphism.Demo3;
/*
     成员方法的访问规则是:
     看new的是谁，就优先用谁，没有则向上找

     口诀:
     成员变量:编译看左边，运行还看左边
     成员方法:编译看左边，运行看右边
 */
public class Demo1 {
    public static void main(String[] args) {
        Fu vae=new Zi();
        vae.method();  //父子都有，子类优先
        vae.methodFu(); // 子类没有，父类有，可以向上找到父类
    }
}
