package com.hs_vae.FunctionalInterface;

import java.util.Arrays;
import java.util.Comparator;

/*
    函数式接口作为返回值进行使用
 */
public class Demo03FunctionalUse {
    //定义一个方法,返回值类型为使用函数式接口Comparator
    public static Comparator<String> getComparator(){
        /*方法的返回值类型是一个接口,那么我们可以返回这个接口的匿名内部类
        return new Comparator<com.hs_vae.String>() {
            @Override
            public int compare(com.hs_vae.String o1, com.hs_vae.String o2) {
                // 按照字符串的长度降序排序
                return o2.length()-o1.length();
            }
        };
        */
        //由于返回值类型是一个函数式接口可以返回一个Lambda表达式
        return ((o1, o2) -> o2.length()-o1.length());
    }

    public static void main(String[] args) {
        String[] arr={"aa", "a", "aaa"};
        Arrays.sort(arr,getComparator());
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
