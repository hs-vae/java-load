package com.hs_vae.Thread.WaitAndNotify;
/*
    生产者(包子铺)类:是一个线程类，可以继承Thread类
    设置线程任务(run):生产包子
    对包子的状态进行判断
    true:有包子
       包子铺调用wait方法进入等待状态
    false:没有包子
       包子铺生产包子
       交替生产两种包子,有两种状态(count%2==0)
       包子铺生产好了包子
       修改包子的状态为true有
       唤醒吃货线程，让吃货线程吃包子
    注意:
       包子铺线程和包子线程关系-->通信(互斥)
       必须同时使用同步技术保证两个线程只有一个在执行
       锁对象必须是保证唯一，可以使用包子对象作为锁对象
       包子铺类和吃货类就需要把包子对象作为参数传递进来
          1.需要在成员位置创建一个包子变量
          2.使用带参数构造方法，为了这个包子变量赋值
 */
public class BaoZiPu extends Thread{
    // 在成员变量位置创建一个包子变量
    private BaoZi bz;

    // 使用带参数构造方法,为这个包子变量赋值
    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }
    //设置线程任务(run):生产包子
    @Override
    public void run() {
        //定义一个变量
        int count=0;
        //让包子铺一直做包子
        while (true){
            synchronized (bz){
                if (bz.flag==true){
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //没有包子,包子铺生成包子
                if (count%2==0){
                    bz.pi="薄皮";
                    bz.xian="香菇白菜陷";
                }else{
                    bz.pi="凉皮";
                    bz.xian="猪肉韭菜陷";
                }
                count++;
                System.out.println("包子铺正在做:"+bz.pi+bz.xian+"包子");
                //做包子需要3秒钟
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //修改包子的状态为true
                bz.flag=true;
                //做好包子唤醒吃货
                bz.notify();
                System.out.println("包子铺已经做好了"+bz.pi+bz.xian+"包子");
            }
        }
    }
}
