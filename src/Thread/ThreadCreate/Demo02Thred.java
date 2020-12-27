package com.hs_vae.Thread.ThreadCreate;
/*
    创建多线程程序的第一种方式:继承Thread类,创建Thread类的子类
    java.lang.Thread类:是描述线程的类,我们想要实现多线程程序,就必须继承Thread类

    实现步骤:
       1.创建一个Thread类的子类
       2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(即开启线程要做什么)
       3.创建Thread类的子类对象
       4.调用Thread类中的方法start方法,开启新的线程,执行run方法
          void start() 使该线程开始执行,java虚拟机调用该线程的run方法
          结果是两个线程并发的运行:当前线程(main线程)和另一个线程(创建的新线程,执行其run方法)
          多次启动一个线程是非法的,特别是当线程已经结束执行后,不能再重新启动
    获取线程的名称:
      1.使用Thread类中的方法getName()
         com.hs_vae.String getName(),返回该线程的名称.
      2.可以先获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称
         static com.hs_vae.Thread currentThread() 返回对当前正在执行的线程对象的引用

    public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停(暂停停止时间)
    毫秒数结束之后,线程继续执行

    设置线程的名称:
     1.使用Thread类中的方法setName(名字)
       void setName(com.hs_vae.String name)改变线程名称,使之与参数name相同
     2.创建一个带参数的构造方法,参数传递线程的名称,调用父类的带参构造方法,把线程名称传递给父类,让父类给子线程取一个名字
       com.hs_vae.Thread(com.hs_vae.String name) 分配新的Thread对象

 */
public class Demo02Thred {

    public static void main(String[] args) {
        // 3.创建Thread类的子类对象
        Mythread th=new Mythread();
        th.setName("hs");
        // 4.调用Thread类中的方法start方法,开启新的线程,执行run方法
        th.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 1.创建一个Thread类的子类
class Mythread extends Thread{
    // 2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(即开启线程要做什么)
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println(this.getName()+":"+i);
        }
    }
}



