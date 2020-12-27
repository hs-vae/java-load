package com.hs_vae.Extends.Demo7RedPackage;

import java.util.ArrayList;

public class Manager extends User{
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int totalMoney,int count) {
        //先定义一个集合来存储若干个红包的金额
        ArrayList<Integer> redList = new ArrayList<>();
        //看群主自己有多少钱,要是余额还没总金额高那就发不了
        int leftMoney = super.getMoney();
        if(totalMoney>leftMoney){
            System.out.println("余额不足");
            return redList;     //没钱就直接退出
        }
        //扣钱,用群主本有的减去将需要发的金额,重新设置金额
        super.setMoney(leftMoney-totalMoney);
        //发红包将红包平均拆分为count份
        int avg=totalMoney / count;
        int mod=totalMoney % count; //余数,就是剩下来的零头

        //将红包放到集合里,先除开最后一个红包
        for (int i = 0; i < count-1; i++) {
            redList.add(avg);
        }
        //将零头包在最后一个红包里
        int last =avg + mod ;
        redList.add(last);

        return redList;
    }
}
