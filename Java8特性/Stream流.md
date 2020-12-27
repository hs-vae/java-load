<!-- toc -->

# Stream流概述

Stream流是一个来自数据源的元素队列

Stream流其实是一个集合元素的函数模型，它不是集合，也不是数据结构，其本身不存储任何元素

Stream 代表了来自某个源的对象的序列，这些序列支持聚集操作。

下面是 Stream 的一些特性：

- 元素序列：Stream 以序列的形式提供了特定类型的元素的集合。根据需求，它可以获得和计算元素，但不会储存任何元素。
- 源：Stream 可以将集合、数组和 I/O 资源作为输入源。
- 聚集操作：Stream 支持诸如 `filter`、`map`、`limit`、`reduce` 等的聚集操作。
- 流水技术：许多 Stream 操作返回了流本身，故它们的返回值可以以流水的行式存在。这些操作称之为中间操作，并且它们的功能就是负责输入、处理和向目标输出。`collect()` 方法是一个终结操作，通常存在于流水线操作的末端，来标记流的结束。
- 自动迭代：Stream 的操作可以基于已提供的源元素进行内部的迭代，而集合则需要显式的迭代

# 流的获取

`java.util.stream.Stream<T>`是Java 8新加入的最常用的流接口(不是函数式接口)

有两种获取流的方式：

* 所有的`Collection`集合(不包括Map集合)都可以通过 `stream` 默认方法获取流

  ```java
  default Stream<E> stream()
  ```

* Stream接口的静态方法`of`可以获取数组对应的流

  ```java
  static <T> Stream<T> of(T...values)   
  ```

## 根据Collection获取流

```java
/*
    把集合转换为Stream流
 */
List<String> list = new ArrayList<>();
Stream<String> stream1 = list.stream();

Set<String> set = new HashSet<>();
Stream<String> stream2 = set.stream();

Map<String,String> map = new HashMap<>();
//获取键,存储到Set集合,再转换为流
Set<String> keySet = map.keySet();
Stream<String> stream3 = keySet.stream();

//获取值,存储到Collection集合中
Collection<String> values = map.values();
Stream<String> stream4 = values.stream();

//获取键值对,存储到set集合
Set<Map.Entry<String, String>> entries = map.entrySet();
Stream<Map.Entry<String, String>> stream5 = entries.stream();
```

## 根据数组获取流

```java
/*
    把数组转换为Stream流
 */
Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
//可变参数可以传递数组
Integer[] arr ={1,2,3,4,5};
Stream.of(arr);
```

# Stream流的常用方法

Stream流的方法可以分为以下两种

1. 延迟方法：返回值类型仍然是Stream接口自身类型的方法，支持链式调用
2. 终结方法：返回值类型不再是Stream接口自身类型的方法，不再支持链式调用，终结方法包括count和forEach方法

## forEach

void forEach(Consumer<? super T> action);

该方法接收一个Consumer接口函数,将每一个流元素交给函数进行处理(消费数据)

forEach方法是终结方法,用来遍历流中的数据,遍历之后就不能继续调用Stream流中其他方法

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;
/*
     void forEach(Consumer<? super T> action);
     该方法接收一个Consumer接口函数,将每一个流元素交给函数进行处理(消费数据)
     forEach方法是终结方法,用来遍历流中的数据,遍历之后就不能继续调用Stream流中其他方法
 */
public class Demo02Stream_forEach {
    public static void main(String[] args) {
        Arrays.asList(1,2,3).stream().forEach(System.out::println); //输出1 2 3
    }
}

```

## filter

Stream流中的filter方法用于对Stream流中的数据进行过滤

Stream<T> filter(Predicate<? super T> predicate);

Predicate中的抽象方法：

 boolean test(T t)

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;

/*
    Stream流中的filter方法用于对Stream流中的数据进行过滤
    Stream<T> filter(Predicate<? super T> predicate);
    Predicate中的抽象方法:
     boolean test(T t)
 */
public class Demo03Stream_filter {
    public static void main(String[] args) {
        //创建一个List集合对于小于3的元素进行过滤
        Arrays.asList(1,2,3,4,5).stream().filter((x)->x>3).forEach(System.out::println);
    }
}
```

## map

Stream流中的map方法,将流中的元素映射到另一个流中

<R> Stream<R> map(Function<? super T,? extends R> mapper);

函数式接口Function中的抽象方法：

  R apply(T t) 根据类型T的参数转换为类型R的结果

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;
import java.util.List;

/*
    Stream流中的map方法,将流中的元素映射到另一个流中
    <R> Stream<R> map(Function<? super T,? extends R> mapper);
    函数式接口Function中的抽象方法:
      R apply(T t) 根据类型T的参数转换为类型R的结果
 */
public class Demo04Stream_map {
    public static void main(String[] args) {
        //定义一个List集合
        List<Integer> list = Arrays.asList(1, 2, 3);
        //使用map方法由1,2,3转换2,4,6即变成2倍并遍历输出
        list.stream().map(x->x*2).forEach(System.out::println);
    }
}
```

## count

Stream流中的count方法用于统计Stream流中元素的个数

long count();

count方法是终结方法,所以使用后不能再继续调用Stream流中的其他方法

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;

/*
   Stream流中的count方法用于统计Stream流中元素的个数
   long count();
   count方法是终结方法,所以使用后不能再继续调用Stream流中的其他方法
 */
public class Demo05Stream_count {
    public static void main(String[] args) {
        long count = Arrays.asList(1, 2, 3).stream().count();
        System.out.println(count);  //3
    }
}
```

## limit

Stream流中的常用方法limit用于截取流中前n个元素

Stream<T> limit(long maxSize);

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;

/*
    Stream流中的常用方法limit用于截取流中前n个元素
 */
public class Demo06Stream_limit {
    public static void main(String[] args) {
        //采用链式编程,定义一个集合转换为流,调用limit方法截取前2个元素并遍历输出
        Arrays.asList(1,2,3,4).stream().limit(2).forEach(System.out::println); //1 2
    }
}
```

## skip

Stream流中的skip方法用于跳过前n个元素

Stream<T> skip(long n);

使用skip方法获取一个截取之后新的流

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
    Stream流中的skip方法用于跳过前n个元素
    使用skip方法获取一个截取之后新的流
 */
public class Demo07Stream_skip {
    public static void main(String[] args) {
        //定义一个集合里面存储4个数字并转换为一个流stream1
        Stream<Integer> stream1 = Arrays.asList(1, 2, 3, 4).stream();
        //使用skip方法跳过前2个元素,并返回一个新的流stream2
        Stream<Integer> stream2 = stream1.skip(2);
        //在跳过之后的新流中遍历输出流中元素
        stream2.forEach(System.out::println);
    }
}
```

## concat

Stream流中的静态方法concat用于把流组合到一起

static <T> Stream<T> concat(Stream(? extends T) a,Stream(? extends T) b)

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/*
   Stream流中的静态方法concat用于把流组合到一起
   static <T> Stream<T> concat(Stream(? extends T) a,Stream(? extends T) b)
 */
public class Demo08Stream_concat {
    public static void main(String[] args) {
        //定义第一个Stream流
        Stream<Integer> stream1 = Arrays.asList(1, 2, 3).stream();
        //定义第二个Stream流
        Stream<String> stream2 = Arrays.asList("a", "b", "c").stream();
        //使用Stream接口中的静态方法concat组合上面两个流,然后遍历输出
        Stream.concat(stream1,stream2).forEach(System.out::println);
    }
}
```

## reduce

reduce方法是通过二元运算对所有元素进行聚合得到一个的流

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;

public class Demo09Stream_reduce {
    public static void main(String[] args) {
        //定义一个存放1,2,3的List集合,转换为流调用reduce方法聚合操作,让元素互相进行相乘,在调用get方法返回该结果
        Integer integer = Arrays.asList(1, 2, 3).stream().reduce((x, y) -> x * y).get();
        System.out.println(integer);
    }
}
```

## mapToInt

IntStream mapToInt(ToIntFunction<? super T> mapper)

使用mapToInt方法返回一个IntStream,其中包含将给定函数应用于此流的元素的结果，在使用summaryStatistics方法产生int类型对象

使用如下

```java
package com.hs_vae.Stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo10Stream_mapToInt {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        /*
            IntStream mapToInt(ToIntFunction<? super T> mapper)
            使用mapToInt方法返回一个IntStream,其中包含将给定函数应用于此流的元素的结果，在使用summaryStatistics方法产生int类型对象
         */
        IntSummaryStatistics stat = list.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("平均数:"+stat.getAverage());
        System.out.println("最大值:"+stat.getMax());
        System.out.println("最小数:"+stat.getMin());
        System.out.println("总和:"+stat.getSum());
    }
}
```