package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    java.util.function.Predicate<T> 接口
    作用:对某种数据类型的数据进行判断,结果返回一个boolean值

    Predicate接口中包含一个抽象方法:
      - boolean test(T t):用来对指定数据类型数据进行判断的方法
        符合条件,返回true
        不符合条件,返回false
 */
public class Demo07PredicateTest {
    //定义一个方法,参数传递一个字符串和Predicate接口,使用接口中的test方法进行判断,并返回结果
    public static boolean checkString(String s, Predicate<String> p){
        return p.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "hs-vae";
        //调用checkString方法对字符串进行校验,参数中包含Predicate接口可以使用Lambda表达式
        //校验规则为该字符串的长度是否大于5
        boolean b = checkString(s, (t) -> t.length() > 4);
        System.out.println(b);  //true
    }
}
