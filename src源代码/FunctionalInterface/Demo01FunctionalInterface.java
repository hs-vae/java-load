package com.hs_vae.FunctionalInterface;
/*
    函数式接口的使用:作为方法的参数
 */
public class Demo01FunctionalInterface {
    public static void main(String[] args) {
        show(new MyFunctionalInterface() {
            @Override
            public void method() {
                System.out.println("使用匿名内部类重写接口中的抽象方法");
            }
        });
        show(()-> System.out.println("使用Lambda表达式重写接口中的抽象方法"));
    }
    //定义一个方法,参数是函数式接口MyFunctionalInterface
    public static void show(MyFunctionalInterface mfi){
        mfi.method();
    }
}
