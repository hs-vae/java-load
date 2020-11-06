<!-- toc -->

java.util.Arrays是一个与数组相关的工具类,里面提供了大量的静态方法,用来实现数组常见的操作

## 一、Arrays数组类常用方法

```java
package Basis.Demo6Arrays;
//Date:2020.10.24
import java.util.Arrays;
/*
       java.util.Arrays是一个与数组相关的工具类,里面提供了大量的静态方法,用来实现数组常见的操作
       public static String toString(数组):将参数数组变成字符串(按照默认格式:[元素1,元素2,元素3..])
       public static void sort(数组): 按照默认升序(从小到大)对数组的元素进行排序,这是void类型的没有返回值
        注意:1.如果是数值,sort默认按照升序从小到大
            2.如果是字符串,sort默认按照字母升序
            3.如果是自定义类型,那么这个自定义的类需要Comparable或者Comparator接口的支持

 */
public class Demo1Arrays {
    public static void main(String[] args) {
        int[] intArray={12,321,325,5};
        String arry1=Arrays.toString(intArray);
        System.out.println(arry1); //[12, 321, 325, 5]
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray)); //[5, 12, 321, 325]
        String[] arry2={"aaa","bbb","ccc"};  
        Arrays.sort(arry2);
        System.out.println(Arrays.toString(arry2));  //[aaa, bbb, ccc]
    }
}

//输出结果
[12, 321, 325, 5]
[5, 12, 321, 325]
[aaa, bbb, ccc]
```

## 二、练习:将一个随机字符串中的所有字符升序排列,并倒序排列

```java
package Basis.Demo6Arrays;
//Date:2020.10.24
import java.util.Arrays;
import java.util.Random;

/*
     练习:将一个随机字符串中的所有字符升序排列,并倒序排列
 */
public class Demo2ArraysPractice {
    public static void main(String[] args) {
        String str="dasdasdashjasdgashjg";
        //将字符串变成一个数组,利用String类的toCharArray方法转化为字符数组
        char[] chars=str.toCharArray();
        //sort方法进行升序排序
        Arrays.sort(chars);
        System.out.println("倒序排列结果:");
        //采用倒序遍历
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]+" ");
        }
    }
}

//输出结果
倒序排列结果:
s s s s s j j h h g g d d d d a a a a a 
```

