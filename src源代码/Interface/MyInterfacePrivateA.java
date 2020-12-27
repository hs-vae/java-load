package com.hs_vae.Interface;
/*
     问题描述:
     假如两个默认方法存在重复代码,我们需要一个共有方法,
     但这个共有的方法不应该让实现类使用，应该是私有化的,所以应该定义一个私有方法
     解决方案:(从java 9开始,接口当中允许定义私有方法)
     1.普通私有方法,解决多个默认方法之间重复代码问题
     格式:
      private 返回值类型 方法名称(参数列表){
             方法体
      }
     2.静态私有方法:解决多个静态方法之间重复代码问题
     格式:
      private static 返回值类型 方法名称(参数列表){
              方法体
      }
 */
public interface MyInterfacePrivateA {
    public default void methodDefualt1(){
        System.out.println("默认方法1");
        commanMethod();
    }
    public default void methodDefualt2(){
        System.out.println("默认方法2");
        commanMethod();
    }
    private void commanMethod(){
        System.out.println("aaaaa");
        System.out.println("bbbbb");
        System.out.println("ccccc");
    }
}
