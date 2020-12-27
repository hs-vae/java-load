<!-- toc -->

## Supplier接口介绍

`java.util.function.Supplier <T>`接口仅包含一个无参的方法：`T get()`，用来获取一个泛型参数指定类型的对象数据

该接口被称为生产型接口,指定接口的泛型是什么类型,那么get方法就会产生什么类型的数据

## 抽象方法get

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Supplier;

/*
    java.util.function.Supplier<T> 接口仅包含一个无参的方法: T get(),用来获取一个泛型参数指定类型的对象数据
    Supplier<T> 接口被称为生产型接口,指定接口的泛型是什么类型,那么get方法就会产生什么类型的数据
 */
public class Demo04SupplierGet {
    //定义一个方法,方法的参数传递Supplier<T>接口,泛型执行String,get方法就返回一个String
    public static String getString(Supplier<String> sup){
        return sup.get();
    }

    public static void main(String[] args) {
        //调用getString方法,参数是一个函数式接口可以使用Lambda表达式
        String s = getString(() -> "hs-vae");
        System.out.println(s);
    }
}
```