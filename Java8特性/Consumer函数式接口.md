<!-- toc -->

## Consumer接口介绍

`java.util.function.Consumer<T>`接口与Supplier接口相反，被称之为消费型接口，它不是生产一个数据，而是消费一个数据，其数据类型由指定的泛型决定

该接口包含抽象方法`void accept(T t)`，作用是消费一个指定泛型的数据，消费是自定义的(输出、计算....)

## 抽象方法accept

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Consumer;

/*
     java.util.function.Consumer<T> 接口与Supplier接口相反，被称之为消费型接口，它不是生产一个数据，而是消费一个数据，其数据类型由指定的泛型决定
     该接口包含抽象方法void accept(T t)，作用是消费一个指定泛型的数据，消费是自定义的(输出,计算....)
 */
public class Demo05ConsumerAccept {
    //定义一个方法,方法的参数传递一个姓名和泛型为String的Consumer接口,可以使用该接口消费姓名
    public static void show(String name, Consumer<String> cs){
        cs.accept(name);
    }

    public static void main(String[] args) {
        //调用show方法,参数里面包含函数式接口Consumer可以使用Lambda表达式
        //消费方式:输出姓名
        show("许嵩", System.out::println);
        //消费方式:反转姓名并输出
        show("许嵩",(String name)->{
            String s = new StringBuffer(name).reverse().toString();
            System.out.println(s);
        });
    }
}

//输出结果
许嵩
嵩许
```

## 默认方法andThen

该方法需要两个Consumer接口，可以把两个Consumer接口组合到一起，在对数据进行消费

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Consumer;

/*
    andThen方法需要两个Consumer接口，可以把两个Consumer接口组合到一起，在对数据进行消费
    例如:
    Consumer<String> con1
    Consumer<String> con2
    String s = "hs-vae";
    连接两个Consumer接口,再进行消费
    con1.andThen(con2).accept(s); 谁先写在前边谁先消费
 */
public class Demo06ConsumerAndThen {
    //定义一个方法,方法的参数传递一个字符串和两个Consumer接口
    public static void show(String s, Consumer<String> con1,Consumer<String> con2){
        //使用andThen方法,把con1和con2两个接口连接到一起,再消费数据(先执行con1再执行con2)
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        //调用show方法,传递一个字符串,可以使用两个Lambda表达式
        show("Hello",
                (t)->{
                    //消费方式:把字符串转换为大写输出
                    System.out.println(t.toUpperCase());
                },
                (t)->{
                    //消费方式:把字符串转换为小写输出
                    System.out.println(t.toLowerCase());
                });  
    }
}

//输出结果
HELLO
hello
```

