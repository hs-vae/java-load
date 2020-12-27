package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.Comparator;

/*
    Lambda表达式有参数有返回值
    建立一个Person对象,按照的年龄进行升序排序
 */
public class Demo03PersonAgeSort {
    public static void main(String[] args) {
        Person[] arr = {
          new Person("许嵩",34),
          new Person("徐良",33),
          new Person("汪苏泷",31)
        };
        //使用匿名内部类
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });
        //使用lambda表达式对数组arr按照年龄进行排序
        Arrays.sort(arr,(p1,p2)-> p1.getAge()- p2.getAge());
        //遍历arr数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
