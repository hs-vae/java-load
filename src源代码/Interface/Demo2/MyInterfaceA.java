package com.hs_vae.Interface.Demo2;

public interface MyInterfaceA {
    public abstract void method();
    public abstract void methodA();
    public default void methodDefault(){
        System.out.println("默认方法AAA");
    }
}
