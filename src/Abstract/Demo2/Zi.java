package com.hs_vae.Abstract.Demo2;

public class Zi extends Fu{
    public Zi(){
        //默认会有一个super();
        System.out.println("子类构造方法已执行");
    }
    @Override
    public void eat(){
        System.out.println("吃炫迈");
    }
}
