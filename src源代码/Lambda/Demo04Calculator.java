package com.hs_vae.Lambda;
/*
    给定一个计算器(Calculator)接口,内含抽象方法calc可以将两个数字相加得到和值
 */
public class Demo04Calculator {
    public static void main(String[] args) {
        //传统方式(匿名内部类)
        show(10, 20, new Calculator() {
            @Override
            public int cal(int a, int b) {
                return a+b;
            }
        });
        //使用Lambda表达式
        show(10, 20, (a, b)-> a+b);
    }
    //定义一个无返回值的方法,打印求和结果
    public static void show(int a,int b,Calculator c){
        System.out.println(c.cal(a,b));
    }
}
