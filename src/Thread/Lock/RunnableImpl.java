package com.hs_vae.Thread.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable{
    //定义一个多个线程共享的票源
    private int ticket=100;
    //在成员位置创建一个ReentrantLock对象
     Lock l=new ReentrantLock();  //使用多态
    //设置线程任务:卖票
    @Override
    public void run() {
        while (true){
            //使用死循环,让卖票重复操作执行
            while(true){
                //在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
                l.lock();
                //先判断票是否存在
                if(ticket>0){
                    try {
                        //提高安全问题出现的概率,让程序睡眠
                        Thread.sleep(10);
                        //如果票存在,卖票ticket
                        System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                        ticket--;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        //在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
                        l.unlock();   //无论是否出现异常,都释放锁
                    }

                }

            }

        }
    }

}
