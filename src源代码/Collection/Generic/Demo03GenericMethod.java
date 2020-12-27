package com.hs_vae.Collection.Generic;
/*
    测试含有泛型的方法
 */
public class Demo03GenericMethod {
    public static void main(String[] args) {
        //创建GenericMethod对象
        GenericMethod gm=new GenericMethod();
        //参数可以为任意的类型,传递什么类型的参数,泛型就是什么类型
        gm.method1("许嵩");
        gm.method1(1);
        gm.method1(1.01);
        gm.method1(false);

        //使用静态方法method2(),使用类名.方法名
        GenericMethod.method2("徐良");
        GenericMethod.method2(2);
        GenericMethod.method2(2.01);
        GenericMethod.method2(true);
    }
}
