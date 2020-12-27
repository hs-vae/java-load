package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    案例需求：
    判断一个字符串,有两个判断的条件,条件一判断字符串的长度是否大于5,条件二字符串是否包含'a' ,两个条件必须同时满足时返回true

    可以使用Predicate接口中的默认方法and
    该方法的源码就是两个判断条件通过逻辑运算符&&(且)连接的
 */
public class Demo08PredicateAnd {
    //定义一个方法,方法的参数传递一个字符串和两个Predicate接口(用于判断两个条件,必须同时成立)
    public static boolean checkString(String s, Predicate<String> p1,Predicate<String> p2){
        return p1.and(p2).test(s); //等同于return p1.test(s)&& p2.test(s)
    }

    public static void main(String[] args) {
        //调用checkString方法,参数传递两个Predicate接口,可以使用两个Lambda表达式
        //一个判断字符串长度是否大于5,另一个判断字符串是否包含'a',仅当同时满足时为返回true
        boolean b = checkString("hs-vae", (t) -> t.length() > 5, (t) -> t.contains("a"));
        System.out.println(b);    //true
    }
}
