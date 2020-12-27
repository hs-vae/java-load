package com.hs_vae.Thread.ThreadCreate;

public class Demo01MainThread {
    public static void main(String[] args) {
        Person p1=new Person("hs");
        p1.run();
        int a=0/0;
        Person p2=new Person("vae");
        p2.run();
    }
}
