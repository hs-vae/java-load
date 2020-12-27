package com.hs_vae.Thread.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
     java.util.concurrent.Executors:线程池的工厂类,用来生成线程池
     Executors类中的静态方法:
        static ExecutorService newFixedThreadPool(int nThreads) 创建一个可重用固定线程数的线程池
        参数:
           int nThread:创建线程池中包含的线程数量
        返回值:
           ExecutorService接口,返回的是ExecutorService接口的实现类对象,可以使用ExecutorService接口接收
     java.util.concurrent.ExecutorService:线程池接口
       用来从线程池中获取线程,调用start方法,执行线程任务
          submit(Runnable task) 提交一个Runnable 任务用于执行
       关闭/销毁线程池的方法
          void shutdown()
     线程池的使用步骤:
       1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
       2.创建一个类,实现Runnable接口,重写run方法,设置线程任务
       3.调用ExecutorService中的方法submit,传递线程任务(实现类),开启线程,执行run方法
       4.调用ExecutorService中的方法shutdown销毁线程池
 */
public class Demo01ThreadPool {
    public static void main(String[] args) {
        //1.使用线程池的工厂类Executors里边提供的静态方法newFixedThreadPool生产一个指定线程数量的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        //3.调用ExecutorService中的方法submit,传递线程任务(实现类),开启线程,执行run方法
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        //4.调用ExecutorService中的方法shutdown销毁线程池
        es.shutdown();
    }
}
