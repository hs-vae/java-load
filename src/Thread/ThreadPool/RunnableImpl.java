package com.hs_vae.Thread.ThreadPool;
//2.创建一个类,实现Runnable接口,重写run方法,设置线程任务
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开启了线程任务!");
    }
}
