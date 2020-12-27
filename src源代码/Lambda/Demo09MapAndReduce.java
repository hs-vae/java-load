package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;

public class Demo09MapAndReduce {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        /*
            使用Stream对象的map方法将原来的列表经由Lambda表达式映射为另一个列表
         */
        number.stream().map(x->x*2).forEach(System.out::println);
        /*
            reduce操作是通过二元运算对所有元素进行聚合得到一个结果
            可以为reduce提供一个接收两个参数的Lambda表达式,相当于一个二元运算
         */
        Integer sum = number.stream().reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }
}
