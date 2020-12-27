package com.hs_vae.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo05Constructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;
        //使用有多个参数构造器创建对象
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor); //public com.hs_vae.Reflect.Person(java.lang.com.hs_vae.String,int)
        Object vae = constructor.newInstance("许嵩", 34);
        System.out.println(vae);   //Person{name='许嵩', age=34, a=0, sex=0.0, flag=false}
    }
}
