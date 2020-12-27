package com.hs_vae.Extends.Demo7RedPackage;

import java.util.ArrayList;

public class MainRedPackage {
    public static void main(String[] args) {
        //创建一个用户对象,规定一个红包需要发的金额100
        User user=new User("用户",100);
        //创建一个群主对象,规定群主自身有的钱20
        Manager manager=new Manager("群主",20);
        //创建一成员对象,定义自身的钱为0
        Member memberA=new Member("成员A",0);
        Member memberB=new Member("成员B",0);
        Member memberC=new Member("成员C",0);
        ArrayList<Integer> list=manager.send(20,3);
        memberA.receive(list);
        memberB.receive(list);
        memberC.receive(list);
        memberA.show();
        memberB.show();
        memberC.show();
        manager.show();
    }
}
