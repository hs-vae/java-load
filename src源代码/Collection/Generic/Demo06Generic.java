package com.hs_vae.Collection.Generic;

import java.util.ArrayList;
import java.util.Collection;

/*
     泛型的上限限定: ? extends E 代表使用的泛型只能是E类型的子类或本身
     泛型的下限限定: ? super  E  代表使用的泛型只能是E类型的父类或本身
 */
public class Demo06Generic {
    public static void main(String[] args) {
        Collection<Integer> list1=new ArrayList<>();
        Collection<String> list2=new ArrayList<>();
        Collection<Number> list3=new ArrayList<>();
        Collection<Object> list4=new ArrayList<>();

        //泛型的上限举例
        getElement1(list1);
//        getElement1(list2);  //报错,因为String类型不是Number类型的子类
        getElement1(list3);
//        getElement1(list4);  //报错,因为Object类型是Number类型的父类而不是子类

        //泛型的下限举例
//        getElement2(list1);  //报错,因为Integer是Number的子类而不是父类
//        getElement2(list2);  //报错,因为String类型不是Number的父类
        getElement2(list3);
        getElement2(list4);
    }

    /*
        类与类之间的继承关系
        Integer extends Number extends Object
        com.hs_vae.String extends Object
     */

    //泛型的上限: 此时的泛型?,必须是Number类型或者是Number类型的子类
    public static void getElement1(Collection<? extends Number> list){
    }
    //泛型的下限: 此时的泛型?,必须是Number类型或者是Number类型的父类
    public static void getElement2(Collection<? super Number> list){
    }
}
