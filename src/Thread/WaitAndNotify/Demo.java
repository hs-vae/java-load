package com.hs_vae.Thread.WaitAndNotify;

public class Demo {
    public static void main(String[] args) {
        //创建包子对象
        BaoZi bz=new BaoZi();
        //创建包子铺线程,开启生产包子
        new BaoZiPu(bz).start();
        //创建吃货线程,开启吃包子
        new ChiHuo(bz).start();
    }
}
