package com.hs_vae.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo06Method {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class;
        //获取空参的成员方法
        Method say = personClass.getMethod("say");
        //执行方法
        Person person = new Person();
        say.invoke(person);
        //获取实参的成员方法
        Method eat = personClass.getMethod("eat", String.class);
        eat.invoke(person,"吃西瓜");
        String name = personClass.getName(); //获取类名
        System.out.println(name); //com.hs_vae.Reflect.Person
    }
}
