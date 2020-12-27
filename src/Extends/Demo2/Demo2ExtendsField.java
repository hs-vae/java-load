package com.hs_vae.Extends.Demo2;
//Date:2020.10.25
/*
      在父子类的继承关系当中,如果成员变量重名,则创建子类对象时,访问有两种方式
      　　1.直接通过子类对象访问成员变量
              等号左边是谁,就优先用谁,没有则向上找
         2.间接通过成员方法访问成员变量
         　　　该方法属于谁,就优先用谁,没有则向上找.
 */
public class Demo2ExtendsField {
    public static void main(String[] args) {
        //创建父类对象
        Fu fu=new Fu();
        System.out.println(fu.numFu);    //只能使用父类的东西,没有任何子类内容,20
        System.out.println("==================");
        //创建子类对象
        Zi zi=new Zi();
        System.out.println(zi.numZi);    //30
        //等号左边是谁,酒优先用谁,没有则向上找
        System.out.println(zi.num);      //300
        System.out.println(fu.num);      //200
//        System.out.println(zi.abc);      //这个abc子类没有,父类也没有,会编译报错

        //这个方法是子类的,优先用子类的,没有再向上找
        zi.ziMethod();
        //这个方法是在父类当中定义的
        fu.fuMethod();

    }
}
