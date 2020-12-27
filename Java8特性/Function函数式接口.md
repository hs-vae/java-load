<!-- toc -->

## Function接口介绍

`java.util.function.Function<T,R>` 接口为一个转换类型的接口，用来根据一个类型的数据得到另一个类型的数据，T称为前置条件，

R称为后置条件

## 抽象方法apply

Function接口中抽象方法为：`R apply (T t)`，根据类型T的参数获取类型R的结果

给出案例

需求：将String类型转换为Integer类型

实现如下

```java
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

```

## 默认方法andThen

Function接口中的默认方法andThen，用来进行组合操作

给出案例

需求：把String类型的"123456"，转换为Integer类型并且加10，再转换为String类型

实现如下

```java
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
```