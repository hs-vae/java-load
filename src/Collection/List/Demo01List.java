package com.hs_vae.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
      java.util.List 接口 extends Collection接口
      List接口的特点:
        1.有序的集合,存储元素和取出元素的顺序是一致的
        2.有索引,包含了一些带索引的方法
        3.允许存储重复的元素
      List接口中带索引的方法(特有)
        - public void add(int index , E element):将指定的元素,添加到该集合中指定的位置上
        - public E get(int index):返回集合中指定位置的元素
        - public E remove(int index):移除列表中指定位置的元素,返回的是被移除的元素
        - public E set(int index , E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素
 */
public class Demo01List {
    public static void main(String[] args) {
        //使用多态创建一个List集合对象
        List<String> list = new ArrayList<>();
        //使用add方法往集合添加元素
        list.add("许嵩");
        list.add("徐良");
        list.add("许嵩");
        System.out.println(list); //[许嵩, 徐良, 许嵩],元素有序且可以重复
        //使用get方法获取指定位置的元素
        String s1 = list.get(0);
        System.out.println(s1); //许嵩
        //使用remove方法删除指定位置的元素
        list.remove(0);
        System.out.println(list); //[徐良, 许嵩]
        //使用set方法替换指定位置的元素
        list.set(0,"汪苏泷");
        System.out.println(list); //[汪苏泷, 许嵩]

        //List集合有三种遍历方式
        //普通的for循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //迭代器
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        //增强for循环
        for (String s : list) {
            System.out.println(s);
        }
    }
}
