package com.hs_vae.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    Collections 集合工具类中的sort(List<T> list,Comparator<? super T>)方法
       - public static <T> void sort(List<T> list,Comparator<? super T>),将集合按照指定规则排序
    Comparator和Comparable的区别
       Comparable:自己(this)和别人(参数)比较,自己需要实现Comparable接口,重写比较的规则compareTo方法
       Comparator:相当于找一个第三方的裁判,来比较两个
    Comparator的排序规则:
       o1-o2:升序
 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list); //[2, 1, 3]
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; //升序
            }
        });
        System.out.println(list);

        //当集合的泛型为Singer时候
        ArrayList<Singer> singers = new ArrayList<>();
        singers.add(new Singer("许嵩",34));
        singers.add(new Singer("汪苏泷",31));
        singers.add(new Singer("徐良",33));
        Collections.sort(singers, new Comparator<Singer>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getAge()- o2.getAge(); //按年龄的升序,排序
            }
        });
        System.out.println(singers);
    }
}
