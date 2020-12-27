package com.hs_vae.FunctionalInterface;

import java.util.function.Function;

public class Demo11FunctionApply {
    /*
        定义一个方法,参数传递一个字符串类型的整数和一个Function接口
        使用Function接口中的方法apply,把字符串类型的整数转换为Integer类型的整数
     */
    public static void change(String s, Function<String,Integer> f){
        Integer i = f.apply(s);
        System.out.println(i);
    }

    public static void main(String[] args) {
        //调用change方法,传递字符串类型的整数,和Lambda表达式
        change("123456",(s)->Integer.parseInt(s));
    }
}
