package com.hs_vae.Polymorphism.Demo4;

public class Cat extends Animal{

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }

   public void run(){
       System.out.println("猫跑起来抓老鼠");
   }
}
