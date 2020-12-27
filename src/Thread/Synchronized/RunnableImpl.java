package com.hs_vae.Thread.Synchronized;

public class RunnableImpl implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true){
              payTicket();
        }
    }

    public synchronized void payTicket(){
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
