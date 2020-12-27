package com.hs_vae.Collection.Generic;

import java.util.ArrayList;
import java.util.Iterator;

public class Demo01Generic {
    public static void main(String[] args) {
        show1();
        show2();
    }
    /*
        创建集合对象,不使用泛型
        优点:集合不使用泛型,默认的类型就是Object类型，可以存储任意类型的数据
        弊端:容易引起异常
     */
    private static void show1(){
        ArrayList list=new ArrayList();
        list.add("这是个字符串");
        list.add(5);
        //使用迭代器遍历list集合
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
            // 当想要使用String类特有的方法length获取字符串的长度时,
            // 由于使用的是多态不能使子类的方法,需要向下转型
            // 会抛出ClassCastException异常,不能把Integer类型转换为String类型
//            com.hs_vae.String s=(com.hs_vae.String) obj;
//            System.out.println(s.length());
        }
    }

    /*
        创建集合对象,使用泛型
        优点:
           1.避免了类型转换的麻烦，存储的是什么类型，取出的就是什么类型
           2.把运行期异常(代码运行之后会抛出的异常)，提升到了编译期(写代码过程中会报错)
        弊端:
            一旦使用泛型，那么泛型是什么类型，就只能存储什么类型
     */
    private static void show2(){
        ArrayList<String> list=new ArrayList<>();
        list.add("字符串1");
        list.add("字符串2");
        //使用迭代器遍历list集合
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String s=it.next();
            System.out.println(s);
            System.out.println(s.length());
        }
    }
}
