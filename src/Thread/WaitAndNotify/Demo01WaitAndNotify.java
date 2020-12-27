package com.hs_vae.Thread.WaitAndNotify;
/*
     等待唤醒案例：线程之间的通信
        创建一个顾客线程(消费者)：告知老板要的包子的种类和数量，调用wait方法，放弃cpu的执行，进入到Waiting状态(无限等待)
        创建一个老板线程(生产者)：花了3秒做包子，做好包子之后调用notify方法，唤醒顾客吃包子

      注意：
        顾客和老板线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须保证唯一
        只有锁对象才能调用wait和notify方法

      Object类(不带参数)的方法
      void wait()
         在其他线程调用此对象的notify()方法或notifyAll()方法前，导致当前线程等待
      void notify()
         唤醒在此对象监听器上等待的单个线程，之后会继续执行wait方法之后的代码

      进入到TimeWaiting(计时等待)有两种方式
        1.使用sleep(long m)方法，在毫秒值结束之后，线程睡醒进入到Runnable/Blocked状态
        2.使用wait(long m)方法，wait方法如果在毫秒值结束之后，还没有被notify唤醒，就会自动醒来
      唤醒的方法:
        void notify() 唤醒在此对象监听器上等待的单个线程
        void notifyAll() 唤醒在此对象监听器上等待的所有线程
 */
public class Demo01WaitAndNotify {
    public static void main(String[] args) {
        //创建一个锁对象
        Object obj=new Object();
        // 创建一个顾客线程(消费者)
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    System.out.println("告知老板要的包子种类和数量");
                    try {
                        //调用wait方法，放弃cpu的执行，进入到Waiting状态(无限等待)
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //唤醒之后的代码
                System.out.println("拿到包子准备开吃!");
            }
        }.start();

        // 创建一个老板线程(生产者)
        new Thread(){
            @Override
            public void run() {
                synchronized (obj){
                    try {
                        //花了3秒钟做包子
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("包子已经做好可以过来取了");
                    //调用notify方法，唤醒顾客吃包子
                    obj.notify();
                }
            }
        }.start();
    }
}
