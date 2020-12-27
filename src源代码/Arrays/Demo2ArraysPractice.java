package com.hs_vae.Arrays;

import java.util.Arrays;

/*
     练习:将一个随机字符串中的所有字符升序排列,并倒序排列
 */
public class Demo2ArraysPractice {
    public static void main(String[] args) {
        String str="dasdasdashjasdgashjg";
        //将字符串变成一个数组,利用String类的toCharArray方法转化为字符数组
        char[] chars=str.toCharArray();
        //sort方法进行升序排序
        Arrays.sort(chars);
        System.out.println("倒序排列结果:");
        //采用倒序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]+" ");
        }
    }
}
