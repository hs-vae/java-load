package com.hs_vae.Arrays;
//Date:2020.10.24
import java.util.Arrays;
/*
       java.util.Arrays是一个与数组相关的工具类,里面提供了大量的静态方法,用来实现数组常见的操作
       public static com.hs_vae.String toString(数组):将参数数组变成字符串(按照默认格式:[元素1,元素2,元素3..])
       public static void sort(数组): 按照默认升序(从小到大)对数组的元素进行排序,这是void类型的没有返回值
        注意:1.如果是数值,sort默认按照升序从小到大
            2.如果是字符串,sort默认按照字母升序
            3.如果是自定义类型,那么这个自定义的类需要Comparable或者Comparator接口的支持

 */
public class Demo1Arrays {
    public static void main(String[] args) {
        int[] intArray={12,321,325,5};
        String arry1=Arrays.toString(intArray);
        System.out.println(arry1);
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        String[] arry2={"aaa","bbb","ccc"};
        Arrays.sort(arry2);
        System.out.println(Arrays.toString(arry2));
    }
}
