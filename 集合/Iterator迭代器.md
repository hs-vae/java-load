<!-- toc -->

# 迭代

即Collection集合元素的通用获取方式，在取元素之前先要判断集合中有没有元素，如果有，就把这个元素取出来，继续在判断，如果还有再取出出来，一直把集合中的所有元素全部取出，这种取出方式专业术语称为迭代。

# Iterator接口的常用方法

boolean hasNext() 判断集合中还有没有下一个元素,有返回true,没有false

E next() 返回迭代的下一个元素,就是取出集合中的下一个元素

Iterator迭代器,是一个接口，不能直接使用所以要使用Iterator实现类对象

Collection接口中有一个方法iterator(),该方法返回的就是迭代器的实现类对象

Iterator<E>  iterator() 返回在此collection的元素上进行迭代的迭代器

# 迭代器使用步骤:

1. 使用集合的方法iterator()获取迭代器的实现类对象,多态写法使用Iterator接口接收
   注意:Iterator<E>接口是有泛型的,要与集合的泛型保持一致
2. 使用Iterator接口中的方法hasNext判断还有没有下一个元素
3. 使用Iterator接口中的方法next取出集合中的下一个元素

实现

```java
package Advanced.Collection;

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
public class Demo02Iterator {
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
```

# 增强for循环

底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写

用来遍历集合和数组

格式:

```java

   for (集合/数组的类型 变量名: 集合名/数组名){
        System.out.println(变量名);
   }
```

实现

```java
package Advanced.Collection;

import java.util.ArrayList;

/*
    增强for循环:
    底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写
    用来遍历集合和数组

    格式:
       for (集合/数组的类型 变量名: 集合名/数组名){
            System.out.println(变量名);
       }
 */
public class Demo03Foreach {
    public static void main(String[] args) {
        // foreach遍历集合
        ArrayList<String> list=new ArrayList<>();
        list.add("许嵩");
        list.add("徐良");
        list.add("汪苏泷");
        for (String s: list) {
            System.out.println(s);
        }
        // foreach遍历数组
        int[] arr={1,2,3};
        for (int a:arr){
            System.out.println(a);
        }
    }
}
```

