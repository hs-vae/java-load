package com.hs_vae.Interface;
/*
       定义默认方法
       格式:
         public default 返回值类型 方法名称(参数列表){
              方法体
         }
        备注:接口当中的默认方法,可以解决接口升级的问题
 */
public interface MyInterfaceDefault {
    public default void def(){
        System.out.println("这是接口的默认方法");
    }
}
