package com.hs_vae.Collection.hashCode;

public class Demo01HashCode {
    public static void main(String[] args) {
        Singer singer1=new Singer();
        int i1 = singer1.hashCode();
        System.out.println(i1);     //哈希值:764977973
        Singer singer2 = new Singer();
        int i2 = singer2.hashCode();
        System.out.println(i2);     //哈希值:381259350

        /*
             String类的哈希值
             String类重写了Object类的hashCode方法
         */
        String s1=new String("许嵩");
        String s2=new String("汪苏泷");
        System.out.println(s1.hashCode());  //哈希值:1132721
        System.out.println(s2.hashCode());  //哈希值:27737586
        //有两个特殊的字符串哈希值一样
        System.out.println("重地".hashCode()); //哈希值:1179395
        System.out.println("通话".hashCode()); //哈希值:1179395

    }
}
