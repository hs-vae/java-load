package com.hs_vae.Collection.Set;

import java.util.HashSet;

/*
      HashSet存储自定义类型元素
      想要使Set集合保证元素唯一
      存储的元素(com.hs_vae.String,Integer,Singer...)必须重写hashCode方法和equals方法
      现在要求Singer歌手同名同年龄的人，视为同一个人，只能存储一次
      如果不覆盖重写会存储两次
 */
public class Demo03HashSetSaveSinger {
    public static void main(String[] args) {
        //创建HashSet集合存储Singer
        HashSet<Singer> set = new HashSet<>();
        Singer s1 = new Singer("许嵩",34);
        Singer s2 = new Singer("汪苏泷",31);
        Singer s3 = new Singer("汪苏泷",31);
        //Singer类覆盖重写hashCode和equals方法后
        System.out.println(s2.hashCode());  //哈希值:859866158
        System.out.println(s3.hashCode());  //哈希值:859866158
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set); //[Singer{name='许嵩', age=34}, Singer{name='汪苏泷', age=31}]
    }
}
