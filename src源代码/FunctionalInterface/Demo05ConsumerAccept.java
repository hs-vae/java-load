package com.hs_vae.FunctionalInterface;

import java.util.function.Consumer;

/*
     java.util.function.Consumer<T> 接口与Supplier接口相反，被称之为消费型接口，它不是生产一个数据，而是消费一个数据，其数据类型由指定的泛型决定
     该接口包含抽象方法void accept(T t)，作用是消费一个指定泛型的数据，消费是自定义的(输出,计算....)
 */
public class Demo05ConsumerAccept {
    //定义一个方法,方法的参数传递一个姓名和泛型为String的Consumer接口,可以使用该接口消费姓名
    public static void show(String name, Consumer<String> cs){
        cs.accept(name);
    }

    public static void main(String[] args) {
        //调用show方法,参数里面包含函数式接口Consumer可以使用Lambda表达式
        //消费方式:输出姓名
        show("许嵩", System.out::println);
        //消费方式:反转姓名并输出
        show("许嵩",(String name)->{
            String s = new StringBuffer(name).reverse().toString();
            System.out.println(s);
        });
    }
}
