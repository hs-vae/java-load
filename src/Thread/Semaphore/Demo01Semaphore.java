package com.hs_vae.Thread.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo01Semaphore {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(1,true);

        for(int i=0;i<10;i++){
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.err.println("线程"+Thread.currentThread().getName()+"进入，已有"+(3-semaphore.availablePermits())+"并发");

                    try {
                        Thread.sleep((long)(Math.random()*1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");

                    semaphore.release();

                    System.err.println("线程"+Thread.currentThread().getName()+"已经离开"+"当前并发数："+(3-semaphore.availablePermits()));
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
