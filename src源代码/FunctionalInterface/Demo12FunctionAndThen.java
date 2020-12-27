package com.hs_vae.FunctionalInterface;

import java.util.function.Function;

/*
     案例需求:把String类型的"123456"，转换为Integer类型并且加10，再转换为String类型
 */
public class Demo12FunctionAndThen {
    /*
       定义一个方法,参数传递一个字符串类型的整数和两个Function接口
       一个接口泛型为<String,Integer>
       另一个接口泛型为<Integer,String>
     */
    public static void change(String s, Function<String,Integer> f1,Function<Integer,String> f2){
        String result = f1.andThen(f2).apply(s);
        System.out.println(result);
    }

    public static void main(String[] args) {
        //调用change方法,传递一个字符串类型的整数和两个Lambda表达式
        change("10",s -> Integer.parseInt(s)+10,i -> i+"");
    }
}
