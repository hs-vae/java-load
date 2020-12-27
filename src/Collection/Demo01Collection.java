package com.hs_vae.Collection;

import java.util.ArrayList;
import java.util.Collection;

/*
     java.util.Collection接口
        所有单列表集合的最顶层接口，里边定义了所有单列集合共性的方法
        任意的单列集合都可以使用Collection接口中的方法

     共性的方法：
        public boolean add(E e):  把给定的元素添加到当前集合中
        public void clear():  清空集合中所有的元素
        public boolean remove(E e):  把给定的对象在当前集合中删除
        public boolean contains(E e): 判断当前集合中是否包含给定的对象
        public boolean isEmpty(): 判断当前集合是否为空
        public int Size(): 返回集合中元素的个数
        public Object[] toArray(): 把集合中的元素，存储到数组中
 */
public class Demo01Collection {
    public static void main(String[] args) {
        //可以使用多态创建一个集合对象
        Collection<Integer> collection=new ArrayList<>();
        // 1.public boolean add(E e):  把给定的元素添加到当前集合中
        boolean b1 = collection.add(1);
        collection.add(3);
        collection.add(2);
        collection.add(4);
        System.out.println(b1);    //true
        System.out.println(collection); //[1, 3, 2, 4]
        // 2.public boolean remove(E e):把给定的对象在当前集合中删除
        boolean b2 = collection.remove(3);
        System.out.println(b2);     //true
        System.out.println(collection);  //[1, 2, 4]
        // 3.public boolean contains(E e): 判断当前集合中是否包含给定的对象
        boolean b3 = collection.contains(3);
        System.out.println(b3);   //false
        // 4.public boolean isEmpty(): 判断当前集合是否为空
        boolean b4 = collection.isEmpty();
        System.out.println(b4);   //false
        // 5.public int Size(): 返回集合中元素的个数
        int size = collection.size();
        System.out.println("size:"+size);   //3
        // 6.public Object[] toArray(): 把集合中的元素，存储到数组中
        Object[] objects = collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);   //[1, 2, 4]
        }
    }
}
