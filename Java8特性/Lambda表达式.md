<!-- toc -->

# Lambda函数式编程思想

语法格式

```
(参数列表) -> {方法体}
```

Lambda表达式是一个匿名函数，基于数学中的λ演算得名

面向对象过程强调的是通过对象的形式来做事情，调用对象的方法来完成事情

而函数式编程思想强调的是做什么，而不是以什么形式做，只看结果，不看过程

# Lambda表达式使用前提

1. **使用Lambda表达式必须具有接口，且要求接口中有且仅有一个抽象方法，比如Runnable接口和Comparator接口**

2. **使用Lambda表达式必须具有上下文推断，也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例**

# Lambda表达式省略格式

Lambda表达式语法：(参数列表) -> {方法体}

**小括号内的参数类型可以省略**

**如果小括号内有且仅有一个推断类型参数，则小括号可以省略**

**如果大括号内有且仅有一个语句即一行语句，则无论是否有返回值，都可以省略大括号、return关键字和语句分号，要注意的是如果要省略那么要一起省略**

举例

参数列表只有一个参数时：

```java
show((int a)->{
   return a++;
});
```

省略格式(省略了{}、return、语句分号、参数的数据类型int、小括号() )

```java
show( a -> a++ );
```

参数列表多个参数时：

```java
show((int a, int b)->{
      return a+b;
});
```

省略格式(省略了{}、return、语句分号、参数的数据类型int )

```java
show((a,b)->a+b);
```

# Lambda表达式的应用

## 使用Lambda表达式的前后对比

当实现多线程时，可以实现Runnable接口创建Thread线程

传统写法

```java
//使用匿名内部类实现多线程
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建该线程");
    }
}).start();
```

这里面当中有很多冗余的代码

使用Lambda表达式

```java
new Thread(()-> System.out.println(Thread.currentThread().getName()+"使用Lambda表达式创建该线程")).start();
```

可以看出来明显代码变得优雅简洁了很多

## 1.使用Lambda表达式实现线程的创建

```java
package com.hs_vae.Lambda;

public class Demo01Thread {
    public static void main(String[] args) {
        //使用匿名内部类实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"创建该线程");
            }
        }).start();

        //使用Lambda表达式实现多线程
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"使用Lambda表达式创建该线程")).start();
    }
}
```

## 2.使用Lambda表达式输出集合内容(forEach)

```java
package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;

/*
     使用Lambda表达式遍历输出List集合
 */
public class Demo05ForEach {
    public static void main(String[] args) {
        String[] arr={"许嵩","汪苏泷","徐良"};
        List<String> list = Arrays.asList(arr);
        //传统的遍历方式
        for (String s : list) {
            System.out.println(s);
        }
        //forEach()方法用于调用数组的每个元素，并将元素传递给回调函数。
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        //使用Lambda表达式遍历,双冒号::为方法引用符合,因为方法System.out已知,对象println也已知
        list.forEach(System.out::println);
    }
}
```

## 3.使用Lambda表达式实现排序(Sort)

```java
package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/*
    使用Lambda表达式实现排序
 */
public class Demo06Lambda {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 3, 1);
        //使用传统方式(匿名内部类)排序并且遍历输出
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });
        //使用Lambda表达式排序和遍历输出简化代码
        Collections.sort(list,((o1, o2) -> o1-o2));
        list.forEach(System.out::println);
    }
}
```

## 4.使用Lambda表达式实现监听器(addActionListener)

```java
package com.hs_vae.Lambda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Demo07Lambda extends JFrame{
    JPanel p;
    JTextArea ta;
    JButton bt1,bt2;
    public Demo07Lambda(){
        super("Lambda 测试");
        p = new JPanel();
        ta = new JTextArea();
        bt1 = new JButton("传统方式");
        bt2 = new JButton("Lambda方式");
        //添加监听器
        //传统写法
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.append("点击传统方式按钮\n");
            }
        });
        //使用Lambda表达式
        bt2.addActionListener(e -> ta.append("点击Lambda方式按钮\n"));
        this.add(ta);
        p.add(bt1);
        p.add(bt2);
        this.add(p, BorderLayout.SOUTH);
        this.setSize(600,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Demo07Lambda().setVisible(true);
    }

```

## 5.自定义Lambda表达式功能

首先定义一个计算器(Calculator)接口,内含抽象方法cal

```java
package com.hs_vae.Lambda;

public interface Calculator {
     int cal(int a,int b);
}
```

Demo

```java
package com.hs_vae.Lambda;
/*
    给定一个计算器(Calculator)接口,内含抽象方法calc可以将两个数字相加得到和值
 */
public class Demo04Calculator {
    public static void main(String[] args) {
        //传统方式(匿名内部类)
        show(10, 20, new Calculator() {
            @Override
            public int cal(int a, int b) {
                return a+b;
            }
        });
        //使用Lambda表达式
        show(10, 20, (a, b)-> a+b);
    }
    //定义一个无返回值的方法,打印求和结果
    public static void show(int a,int b,Calculator c){
        System.out.println(c.cal(a,b));
    }
}
```

## 6.使用Lambda操作Predicate接口实现数据过滤

```java
package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class Demo08Predicate {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6);
        //Predicate来定义测试的标准，返回是否测试通过,传统(匿名内部类)写法
        show(number, new Predicate() {
            @Override
            public boolean test(Object o) {
                return (int)o%2==0;
            }
        });
        //使用Lambda表达式过滤能被2整除的number
        show(number,x->(int)x%2==0);   
    }
    public static void show(List list,Predicate condition){
        //过滤filter方法中传入Predicate接口，再调用测试方法test，根据测试的规则，判断输入的参数是否测试通过
        list.stream().filter(x->condition.test(x)).forEach(System.out::println);
    }
}
```

## 7.使用Lambda操作Map映射和Reduce聚合

```java
package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.List;

public class Demo09MapAndReduce {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        /*
            使用Stream对象的map方法将原来的列表经由Lambda表达式映射为另一个列表
         */
        number.stream().map(x->x*2).forEach(System.out::println);
        /*
            reduce操作是通过二元运算对所有元素进行聚合得到一个结果
            可以为reduce提供一个接收两个参数的Lambda表达式,相当于一个二元运算
         */
        Integer sum = number.stream().reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }
}
```

## 8.使用Lambda获取数字个数、最小值、最大值、总和(summaryStatistics)

```java
package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo10SunmaryStatistics {
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