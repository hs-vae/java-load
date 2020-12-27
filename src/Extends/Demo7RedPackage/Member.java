package com.hs_vae.Extends.Demo7RedPackage;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }
    public void receive(ArrayList<Integer> list){
          //从多个红包当中随机抽取一个给自己,随机获取一个集合的索引编号
          int index=new Random().nextInt(list.size());
          //根据索引,从集合当中删除,而且得到这个红包给自己
          int delta=list.remove(index);
          //当前成员自己本来有多少钱
          int money=super.getMoney();
          //加法,自己本来的钱money加上获取的钱detal,等于最终的钱,并且重新设置回去
          super.setMoney(delta+money);
    }
}
