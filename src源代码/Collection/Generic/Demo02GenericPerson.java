package com.hs_vae.Collection.Generic;

public class Demo02GenericPerson {
    public static void main(String[] args) {
        //不写泛型默认为Object类型
        Person p1=new Person();
        p1.setName("许嵩");
        Object obj = p1.getName();
        System.out.println(obj);

        //创建Person对象,泛型类型为Integer
        Person<Integer> p2=new Person<>();
        p2.setName(2);    //这时候只能存储int类型
        Integer integer= p2.getName();
        System.out.println(integer);

        //创建Person对象,泛型类型为String
        Person<String> p3=new Person<>();
        p3.setName("徐良");   //这时候只能存储String类型
        String name = p3.getName();
        System.out.println(name);
    }
}
