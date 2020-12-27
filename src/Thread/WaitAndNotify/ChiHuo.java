package com.hs_vae.Thread.WaitAndNotify;
/*
   消费之(吃货)类：是一个线程类,可以继承Thread
   设置线程任务(run)：吃包子
   对包子的状态进行判断
   false:没有包子
     吃货调用wait方法进入等待状态
   true:有包子
     吃货吃包子
     吃货吃完包子
     修改包子的状态为false没有
     吃货唤醒包子铺线程,生产包子
 */
public class ChiHuo extends Thread{
    // 在成员变量位置创建一个包子变量
    private BaoZi bz;

    // 使用带参数构造方法,为这个包子变量赋值
    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run)：吃包子
    @Override
    public void run() {
        //使用死循环一直吃包子
        while (true){
            synchronized (bz){
                if (bz.flag==false){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃货正在吃"+bz.pi+bz.xian+"包子");
                //吃货吃完包子后修改包子状态为false
                bz.flag=false;
                //唤醒包子铺去做包子
                bz.notify();
                System.out.println("吃货已经吃完"+bz.pi+bz.xian+"包子,包子铺开始做包子");
                System.out.println("------------------------------------------");
            }
        }
    }
}
