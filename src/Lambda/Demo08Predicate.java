package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Demo08Predicate {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6);
        //Predicate来定义测试的标准，返回是否测试通过,传统(匿名内部类)写法
        show(number, new Predicate() {
            @Override
            public boolean test(Object o) {
                return (int)o%2==0;
            }
        });
        //使用Lambda表达式过滤能被2整除的number
        show(number,x->(int)x%2==0);
    }
    public static void show(List list,Predicate condition){
        //过滤filter方法中传入Predicate接口，再调用测试方法test，根据测试的规则，判断输入的参数是否测试通过
        list.stream().filter(x->condition.test(x)).forEach(System.out::println);
    }
}
