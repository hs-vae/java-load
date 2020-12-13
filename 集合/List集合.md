<!-- toc -->

# List集合的介绍

List接口继承了Collection接口

是单列集合的一个重要分支

在List集合中允许出现重复的元素

所有的元素是以一种线性的方式进行存储的

也就是可以通过索引来访问集合中的指定元素

List集合中的元素是有序的

即元素的存入顺序和取出顺序一致

List集合的特点

```java
java.util.List 接口 extends Collection接口
1.有序的集合,存储元素和取出元素的顺序是一致的
2.有索引,包含了一些带索引的方法   
3.允许存储重复的元素
```

# List集合中常用的方法

List集合中带索引的方法(特有)

```java
- public void add(int index , E element):将指定的元素,添加到该集合中指定的位置上
- public E get(int index):返回集合中指定位置的元素
- public E remove(int index):移除列表中指定位置的元素,返回的是被移除的元素
- public E set(int index , E element):用指定元素替换集合中指定位置的元素,返回值的更新前的元素
```

测试如下

```java
package Advanced.Collection.List;

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

```

# LinkedList集合

LinkedList 集合数据存储的结构是链表结构，方便元素添加和删除

特点：

1. 底层是一个链表结构
2. 包含了很多操作首尾元素的方法

LinkedList集合提供了很多首尾操作的方法

```java
- public void addFirst(E e):将指定元素插入此列表的开头
- public void addLast(E e):将指定元素添加到此列表的结尾
- public E getFirst():返回此列表的第一个元素
- public E getLast():返回此列表的最后一个元素
- public E removeFirst():移除并返回此列表的第一个元素
- public E removeLast():移除并返回此列表的最后一个元素
- public E pop():从此列表所表示的堆栈弹出一个元素
- public void push(E e):将元素推入此列表所表示的堆栈
- public boolean isEmpty():如果列表不包含元素,则返回true
```

测试如下

```java
package Advanced.Collection.List;

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
```

