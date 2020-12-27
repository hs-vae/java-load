package com.hs_vae.Arrays;
/*
       java.util.Math类是数学相关的工具类,里面提供了大量的静态方法,完成与数学运算相关的操作.
         -public static double abs(double num):获取绝对值,有多种重载
         -public static double ceil(double num):向上取整,比如30.1向上取整为31.0
         -public static double floor(double num):向下取整,比如30.9向下取整为30.0
         -public static long round(double num):四舍五入,结果都是整数不带小数点的

         Math.PI代表近似的圆周率常量(double)
 */
public class Demo3Math {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2));     //2
        System.out.println(Math.ceil(30.1));  //31.0
        System.out.println(Math.floor(30.9));  //30.0
        System.out.println(Math.round(30.4));  //30
        System.out.println(Math.round(30.5));  //31
    }
}
