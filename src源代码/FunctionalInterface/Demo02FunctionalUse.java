package com.hs_vae.FunctionalInterface;
/*
     函数式接口作为方法的参数进行使用
*/
public class Demo02FunctionalUse {
    //定义一个方法threadStart,参数使用函数式接口Runnable
    public static void threadStart(Runnable runnable){
        new Thread(runnable).start();
    }

    public static void main(String[] args) {
        //调用threadStart方法,方法的参数是一个接口,可以传递这个接口的匿名内部类
        threadStart(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开启线程");
            }
        });
        //使用Lambda表达式优化
        threadStart(()->System.out.println(Thread.currentThread().getName()+"开启线程"));
    }
}
