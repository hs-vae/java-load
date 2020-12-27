package com.hs_vae.Extends.Demo6;
/*
     super关键字的用法有三种:
     1.在子类的成员方法中,访问父类的成员变量
     2.在子类的成员方法中,访问父类的成员方法
     3.在子类的构造方法中,访问父类的构造方法
 */
public class Zi extends Fu {
      int num=20;
      public void methodZi(){
          System.out.println(super.num);
      }
      public void method() {
        super.method();  //访问父类的method
        System.out.println("子类方法");
      }
      public Zi(){
          super();
      }
      public void showNum(){
          int num=30;
          System.out.println(num);  //访问局部变量num,直接写   30
          System.out.println(this.num);  //访问本类Zi成员变量num  20
          System.out.println(super.num); //访问父类成员变量num  10
      }

}
