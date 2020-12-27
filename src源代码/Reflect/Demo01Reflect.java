package com.hs_vae.Reflect;
/*
    获取Class对象的三种方式
 */

public class Demo01Reflect {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.通过Class.forName("全限定类名")获取
        Class cls1 = Class.forName("com.hs_vae.Reflect.Person");
        //2.通过类名.class获取
        Class cls2 = Person.class;
        //3.通过对象.getClass()获取
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls1);  //class com.hs_vae.Reflect.Person
        System.out.println(cls2);  //class com.hs_vae.Reflect.Person
        System.out.println(cls3);  //class com.hs_vae.Reflect.Person
        System.out.println(cls1.equals(cls2)); //true
    }
}
