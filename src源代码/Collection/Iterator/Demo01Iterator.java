package com.hs_vae.Collection.Iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
      java.util.Iterator接口:迭代器(对集合进行遍历)
      有两个常用的方法
         boolean hasNext() 判断集合中还有没有下一个元素,有返回true,没有false
         E next() 返回迭代的下一个元素,就是取出集合中的下一个元素
      Iterator迭代器,是一个接口，不能直接使用所以要使用Iterator实现类对象
      Collection接口中有一个方法iterator(),该方法返回的就是迭代器的实现类对象
         Iterator<E>  iterator() 返回在此collection的元素上进行迭代的迭代器
      迭代器使用步骤:
         1.使用集合的方法iterator()获取迭代器的实现类对象,多态写法使用Iterator接口接收
            注意:Iterator<E>接口是有泛型的,要与集合的泛型保持一致
         2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
         3.使用Iterator接口中的方法next取出集合中的下一个元素

 */
public class Demo01Iterator {
    public static void main(String[] args) {
        // 先创建一个集合对象,实现ArrayList类
        Collection<String> coll=new ArrayList<>();
        // 给该集合添加元素
        coll.add("许嵩");
        coll.add("徐良");
        coll.add("汪苏泷");
        /*
           使用迭代器输出这个集合中所有的元素
         */
        // 使用集合的方法iterator()获取迭代器的实现类对象,多态写法使用Iterator接口接收
        Iterator<String> it = coll.iterator();
        /*
           使用Iterator接口中的方法hasNext判断还有没有下一个元素
           使用Iterator接口中的方法next取出集合中的下一个元素
           可以使用while循环遍历输出,结束条件就是没有下一个元素hasNext返回false
         */
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
