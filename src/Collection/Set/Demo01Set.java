package com.hs_vae.Collection.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
      java.util.Set接口 extends Collection接口
      Set接口的特点:
         1.不允许存储重复的元素
         2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
      java.util.HashSet集合  implements Set接口
      HashSet特点:
         1.不允许存储重复的元素
         2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历,只能使用迭代器或增强for循环
         3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
         4.底层是一个哈希表结构,查询的速度非常快
 */
public class Demo01Set {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //使用add方法添加元素到集合
        set.add("许嵩");
        set.add("徐良");
        set.add("许嵩");
        set.add("徐良");
        //使用迭代器遍历set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        //增强for循环遍历set集合
//        for (com.hs_vae.String s : set) {
//            System.out.println(s);
//        }
    }
}
