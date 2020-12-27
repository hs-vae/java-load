package com.hs_vae.Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo02Semaphore {
    public static void main(String[] args) {
        //启动线程池,有多少线程启动多少
        ExecutorService executorService = Executors.newCachedThreadPool();
        //启动信号灯,设置一次可进入3个.是否公平默认的情况为true,所以直接new Semaphore(N)就行
        final Semaphore sem=new Semaphore(3);
        //创建10个线程
        for (int i = 1; i < 10; i++) {
            //内部类使用外部类的变量必须是final型
            final int index=i;
            Thread thread=new Thread(new Runnable() {
                @Override
                public void run() {
                //获取许可
                    try {
                        sem.acquire();
                        System.out.println("已进入"+index+"个线程,还可进入"+sem.availablePermits());
                        Thread.sleep(1000);
                        //释放资源
                        sem.release();
                        System.out.println("空余出"+sem.availablePermits()+"个");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}
