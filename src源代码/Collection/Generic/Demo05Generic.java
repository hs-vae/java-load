package com.hs_vae.Collection.Generic;

import java.util.ArrayList;
import java.util.Iterator;

/*
    泛型的通配符:
       ?:代表任意的数据类型
    使用方式:
       不能创建对象使用
       只能作为方法的参数使用
 */
public class Demo05Generic {
    public static void main(String[] args) {
        //当确定泛型的类型时,可以直接创建集合对象,指定泛型的类型
        ArrayList<String> list1=new ArrayList<>();
        list1.add("许嵩");
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(2);
        //不确定泛型的类型时,可以定义一个方法,参数采用通配符
        printArrayList(list2);
//        com.hs_vae.ArrayList<?> list3=new com.hs_vae.ArrayList<?>();  //错误写法,不能够创建对象时候使用通配符
    }
    /*
         定义一个方法用来遍历输出ArrayList集合,由于不知道该集合的泛型是什么类型,可以使用通配符?
         注意的是泛型是没有继承概念的
     */
    public static void printArrayList(ArrayList<?> list){
        Iterator<?> it = list.iterator();
        while (it.hasNext()){
            //it.next()的方法取出的元素是Object类型,能够接收任意的数据类型
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}
