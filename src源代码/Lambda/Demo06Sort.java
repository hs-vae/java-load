package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
    使用Lambda表达式实现排序
 */
public class Demo06Sort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 1);
        //使用传统方式(匿名内部类)排序并且遍历输出
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //使用Lambda表达式排序和遍历输出简化代码
        Collections.sort(list,((o1, o2) -> o1-o2));
        list.forEach(System.out::println);
    }
}
