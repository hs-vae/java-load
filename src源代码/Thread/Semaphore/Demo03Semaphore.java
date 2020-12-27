package com.hs_vae.Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo03Semaphore {
    private static final int SEM_MAX = 10;
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(SEM_MAX);
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //在线程池中执行任务
        threadPool.execute(new MyThread(sem, 5));
        threadPool.execute(new MyThread(sem, 4));
        threadPool.execute(new MyThread(sem, 7));
        //关闭池
        threadPool.shutdown();
    }
}

class MyThread extends Thread {
    private volatile Semaphore sem;    // 信号量
    private int count;        // 申请信号量的大小 

    MyThread(Semaphore sem, int count) {
        this.sem = sem;
        this.count = count;
    }
    @Override
    public void run() {
        try {
            // 从信号量中获取count个许可
            sem.acquire(count);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " acquire count="+count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放给定数目的许可，将其返回到信号量。
            sem.release(count);
            System.out.println(Thread.currentThread().getName() + " release " + count + "");
        }
    }
}