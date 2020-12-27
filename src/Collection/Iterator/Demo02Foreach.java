package com.hs_vae.Collection.Iterator;

import java.util.ArrayList;

/*
    增强for循环:
    底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写
    用来遍历集合和数组

    格式:
       for (集合/数组的类型 变量名: 集合名/数组名){
            System.out.println(变量名);
       }
 */
public class Demo02Foreach {
    public static void main(String[] args) {
        // foreach遍历集合
        ArrayList<String> list=new ArrayList<>();
        list.add("许嵩");
        list.add("徐良");
        list.add("汪苏泷");
        for (String s: list) {
            System.out.println(s);
        }
        // foreach遍历数组
        int[] arr={1,2,3};
        for (int a:arr){
            System.out.println(a);
        }
    }
}
