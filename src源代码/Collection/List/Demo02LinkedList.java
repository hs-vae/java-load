package com.hs_vae.Collection.List;

import java.util.LinkedList;

/*
     java.util.LinkedList集合 implements List接口
     LinkedList集合的特点:
       1.底层是一个链表结构
       2.包含了很多操作首尾元素的方法
     注意:使用LinkedList集合特有的方法就不能使用多态
     - public void addFirst(E e):将指定元素插入此列表的开头
     - public void addLast(E e):将指定元素添加到此列表的结尾
     - public E getFirst():返回此列表的第一个元素
     - public E getLast():返回此列表的最后一个元素
     - public E removeFirst():移除并返回此列表的第一个元素
     - public E removeLast():移除并返回此列表的最后一个元素
     - public E pop():从此列表所表示的堆栈弹出一个元素
     - public void push(E e):将元素推入此列表所表示的堆栈
     - public boolean isEmpty():如果列表不包含元素,则返回true
 */
public class Demo02LinkedList {
    public static void main(String[] args) {
        method01();
    }
    public static void method01(){
        //创建LinkedList集合对象
        LinkedList<String> linked = new LinkedList<>();
        //使用add方法往集合添加元素
        linked.add("许嵩");
        linked.add("徐良");
        linked.add("汪苏泷");
        System.out.println(linked); //[许嵩, 徐良, 汪苏泷]
        /*
            关于第一个元素First的操作
         */
        //使用addFirst方法在开头第一个插入元素,该方法等效于push
        linked.addFirst("周杰伦");
        System.out.println(linked); //[周杰伦, 许嵩, 徐良, 汪苏泷]
        //使用getFirst方法获取第一个元素
        System.out.println(linked.getFirst());  //周杰伦
        //使用removeFirst方法删除第一个元素
        linked.removeFirst();
        System.out.println(linked); //[许嵩, 徐良, 汪苏泷]
        /*
            关于最后一个元素Last的操作
         */
        //使用addLast方法在结尾添加一个元素,等效于add
        linked.addLast("单色凌");
        System.out.println(linked);  //[许嵩, 徐良, 汪苏泷, 单色凌]
        //使用getLast方法获取第一个元素
        System.out.println(linked.getLast());  //单色凌
        //使用removeLast方法删除最后一个元素
        linked.removeLast();
        System.out.println(linked);  //[许嵩, 徐良, 汪苏泷]
        //判断该集合是否为空
        boolean empty = linked.isEmpty();
        System.out.println(empty);  //false
        //清空该表
        linked.clear();
        System.out.println(linked.isEmpty()); //true
    }
}
