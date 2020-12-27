package com.hs_vae.Interface.Demo2;

public interface MyInterfaceB {
    public abstract void method();
    public abstract void methodB();
    public default void methodDefault(){
        System.out.println("默认方法BBB");
    }
}
