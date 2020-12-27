<!-- toc -->

## Predicate接口介绍

当我们需要对某种类型的数据进行判断，从而得到一个boolean值结果，这时可以使用`java.util.function.Predicate<T>` 接口

## 抽象方法test

boolean test(T t)：用来对指定数据类型数据进行判断的方法

符合条件，返回true

不符合条件，返回false

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    java.util.function.Predicate<T> 接口
    作用:对某种数据类型的数据进行判断,结果返回一个boolean值

    Predicate接口中包含一个抽象方法:
      - boolean test(T t):用来对指定数据类型数据进行判断的方法
        符合条件,返回true
        不符合条件,返回false
 */
public class Demo07PredicateTest {
    //定义一个方法,参数传递一个字符串和Predicate接口,使用接口中的test方法进行判断,并返回结果
    public static boolean checkString(String s, Predicate<String> p){
        return p.test(s);
    }

    public static void main(String[] args) {
        //定义一个字符串
        String s = "hs-vae";
        //调用checkString方法对字符串进行校验,参数中包含Predicate接口可以使用Lambda表达式
        //校验规则为该字符串的长度是否大于5
        boolean b = checkString(s, (t) -> t.length() > 4);
        System.out.println(b);  //true
    }
}
```

## 默认方法and

给出一个案例

需求为：判断一个字符串，有两个判断的条件，第一判断字符串的长度是否大于5，第二字符串是否包含'a' ，两个条件必须同时满足返回true

按照往常可以使用逻辑运算符&&连接两个条件

不过Predicate接口中有一个默认方法and，表示并且关系，也可以用于连接两个判断条件

该方法内部的两个判断条件就是使用逻辑运算符&&连接起来的

使用如下

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    案例需求：
    判断一个字符串,有两个判断的条件,条件一判断字符串的长度是否大于5,条件二字符串是否包含'a' ,两个条件必须同时满足时返回true

    可以使用Predicate接口中的默认方法and
    该方法的源码就是两个判断条件通过逻辑运算符&&(且)连接的
 */
public class Demo08PredicateAnd {
    //定义一个方法,方法的参数传递一个字符串和两个Predicate接口(用于判断两个条件,必须同时成立)
    public static boolean checkString(String s, Predicate<String> p1,Predicate<String> p2){
        return p1.and(p2).test(s); //等同于return p1.test(s)&& p2.test(s)
    }

    public static void main(String[] args) {
        //调用checkString方法,参数传递两个Predicate接口,可以使用两个Lambda表达式
        //一个判断字符串长度是否大于5,另一个判断字符串是否包含'a',仅当同时满足时为返回true
        boolean b = checkString("hs-vae", (t) -> t.length() > 5, (t) -> t.contains("a"));
        System.out.println(b);    //true
    }
}
```

## 默认方法or

给出一个案例

需求为：判断一个字符串，有两个判断的条件，第一判断字符串的长度是否大于5，第二字符串是否包含'a' ，当满足一个条件时返回true

按照往常可以使用逻辑运算符||连接两个条件

不过Predicate接口中有一个默认方法or，表示或关系，也可以用于连接两个判断条件

or方法内部的两个判断条件就是使用逻辑运算||符连接起来的

使用如下

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    案例需求：
    判断一个字符串,有两个判断的条件,条件一判断字符串的长度是否大于5,条件二字符串是否包含'a' ,一个条件成立时返回true

    可以使用Predicate接口中的默认方法or
    该方法的源码就是两个判断条件通过逻辑运算符||(或)连接的
 */
public class Demo09PredicateOr {
    //定义一个方法,方法的参数传递一个字符串和两个Predicate接口(用于判断两个条件,一个条件成立即可)
    public static boolean checkString(String s, Predicate<String> p1, Predicate<String> p2){
        return p1.or(p2).test(s); //等同于return p1.test(s)|| p2.test(s)
    }

    public static void main(String[] args) {
        //调用checkString方法,参数传递两个Predicate接口,可以使用两个Lambda表达式
        //一个判断字符串长度是否大于5,另一个判断字符串是否包含'a',仅当同时满足时为返回true
        boolean b = checkString("vae", (t) -> t.length() > 5, (t) -> t.contains("a"));
        System.out.println(b);    //true
    }
}

```

## 默认方法negate

给出一个案例

需求为：判断一个字符串的长度是否大于5，如果字符串长度大于5返回false，反之返回true

可以使用取反符号!对判断的结果进行取反

也可以使用Predicate接口中的默认方法negate，也表示取反的意思

使用如下

```java
package com.hs_vae.FunctionalInterface;

import java.util.function.Predicate;

/*
    案例需求: 判断一个字符串的长度是否大于5
    如果字符串长度大于5返回false,反之返回true
    可以使用取反符号!对判断的结果进行取反

    Predicate接口中的默认方法negate,也表示取反的意思
    default Predicate<T> negate(){
        return (t) -> !test(t);
    }
 */
public class Demo10PredicateNegate {
    //定义一个方法,参数传递一个字符串和一个Predicate接口(判断字符串长度是否大于5)
    public static boolean checkString(String s , Predicate<String> p){
        return p.negate().test(s); //等同于return !p.test(s);
    }

    public static void main(String[] args) {
        //调用checkString方法,参数传递了一个Predicate接口,可以使用Lambda表达式
        boolean b = checkString("vae", (t) -> t.length() > 5);
        System.out.println(b);   //true
    }
}
```