package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    案例需求: 判断一个字符串的长度是否大于5
    如果字符串长度大于5返回false,反之返回true
    可以使用取反符号!对判断的结果进行取反

    Predicate接口中的默认方法negate,也表示取反的意思
    default Predicate<T> negate(){
        return (t) -> !test(t);
    }
 */
public class Demo10PredicateNegate {
    //定义一个方法,参数传递一个字符串和一个Predicate接口(判断字符串长度是否大于5)
    public static boolean checkString(String s , Predicate<String> p){
        return p.negate().test(s); //等同于return !p.test(s);
    }

    public static void main(String[] args) {
        //调用checkString方法,参数传递了一个Predicate接口,可以使用Lambda表达式
        boolean b = checkString("vae", (t) -> t.length() > 5);
        System.out.println(b);   //true
    }
}
