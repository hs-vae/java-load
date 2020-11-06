<!-- toc -->

java.util.Math类是数学相关的工具类,里面提供了大量的静态方法,完成与数学运算相关的操作.

## 一、Math类常用方法

```java
package Basis.Demo6Arrays;
/*
       java.util.Math类是数学相关的工具类,里面提供了大量的静态方法,完成与数学运算相关的操作.
         -public static double abs(double num):获取绝对值,有多种重载
         -public static double ceil(double num):向上取整,比如30.1向上取整为31.0
         -public static double floor(double num):向下取整,比如30.9向下取整为30.0
         -public static long round(double num):四舍五入,结果都是整数不带小数点的

         Math.PI代表近似的圆周率常量(double)
 */
public class Demo3Math {
    public static void main(String[] args) {
        System.out.println(Math.abs(-2));     
        System.out.println(Math.ceil(30.1));  
        System.out.println(Math.floor(30.9));  
        System.out.println(Math.round(30.4));  
        System.out.println(Math.round(30.5));  
    }
}

//输出结果
2
31.0
30.0
30
31
```

## 二、练习:计算在-10.8到5.9之间,绝对值大于6或者小于2.1的整数有多少个?

```java
package Basis.Demo6Arrays;
/*
     练习:计算在-10.8到5.9之间,绝对值大于6或者小于2.1的整数有多少个?
 */
public class Demo4MathPractice {
    public static void main(String[] args) {
        double max=5.9;
        double min=-10.8;
        int count=0;
        for (int i=(int) min;i<max;i++){ //将min强转int类型相当于为-10
            int abs=Math.abs(i);         //获取i的绝对值
            if (abs>6 || abs<2.1) {      //判定条件:绝对值大于6或小于2.1
                System.out.println(i);
                count++;
            }
        }
        System.out.println("符号要求的整数个数为:"+count);
    }
}
//输出结果
-10,-9,-8,-7,-2,-1,0,1,2,符号要求的整数个数为:9
```

