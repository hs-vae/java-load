package com.hs_vae.Arrays;
/*
     练习:计算在-10.8到5.9之间,绝对值大于6或者小于2.1的整数有多少个?
 */
public class Demo4MathPractice {
    public static void main(String[] args) {
        double max=5.9;
        double min=-10.8;
        int count=0;
        for (int i=(int) min;i<max;i++){ //将min强转int类型相当于为-10
            int abs=Math.abs(i);         //获取i的绝对值
            if (abs>6 || abs<2.1) {      //判定条件:绝对值大于6或小于2.1
                System.out.print(i+",");
                count++;
            }
        }
        System.out.println("符号要求的整数个数为:"+count);
    }
}
