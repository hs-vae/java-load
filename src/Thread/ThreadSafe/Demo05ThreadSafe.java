package com.hs_vae.Thread.ThreadSafe;
/*
   线程安全问题代码实现(电影院卖票案例)
 */
public class Demo05ThreadSafe {
    public static void main(String[] args) {
        RunnbaleImpl run=new RunnbaleImpl();
        Thread t1=new Thread(run);
        Thread t2=new Thread(run);
        Thread t3=new Thread(run);
        t1.start();
        t2.start();
        t3.start();
    }
}

class RunnbaleImpl implements Runnable{
    private int ticket=100;
    Object obj=new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj){
                if(ticket>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"正在卖第"+ticket+"张票");
                    ticket--;
                }
            }
        }

    }
}
