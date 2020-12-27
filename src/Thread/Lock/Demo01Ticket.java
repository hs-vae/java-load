package com.hs_vae.Thread.Lock;

public class Demo01Ticket {
    public static void main(String[] args) {
        //创建Runnable接口的实现类对象
        RunnableImpl run=new RunnableImpl();
        //创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        //调用start方法开启多线程
        t1.start();
        t2.start();
        t3.start();
    }
}
