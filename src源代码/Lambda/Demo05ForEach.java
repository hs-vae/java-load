package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;

/*
     使用Lambda表达式遍历输出List集合
 */
public class Demo05ForEach {
    public static void main(String[] args) {
        String[] arr={"许嵩","汪苏泷","徐良"};
        List<String> list = Arrays.asList(arr);
        //传统的遍历方式
        for (String s : list) {
            System.out.println(s);
        }
        //forEach()方法用于调用数组的每个元素，并将元素传递给回调函数。
        /*list.forEach(new Consumer<com.hs_vae.String>() {
            @Override
            public void accept(com.hs_vae.String s) {
                System.out.println(s);
            }
        });*/
        //使用Lambda表达式遍历,双冒号::为方法引用符合,因为方法System.out已知,对象println也已知
        list.forEach(System.out::println);
    }
}
