package com.hs_vae.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/*
     案例:获取指定类的构造方法信息

     获取构造方法们
     Constructor<?>[] getConstructors()
     Constructor<T>  getConstructor(类<?>....parameterTypes)
     Constructor<?>[] getDeclaredConstructors()
     Constructor<T> getDeclaredConstructor(类<?>....parameterTypes)
     Constructor常用方法如下
      - com.hs_vae.String  getName() 返回构造方法的名称
      - Class[] getParameterTypes() 返回当前构造方法的参数类型
      - int   getModifiers() 返回修饰符的整型标识,需要使用Modifier工具类的方法解码后才能获得真实的修饰符
 */
public class Demo03Constructor {
    public static void main(String[] args) {
        try {
            //获取String类对象
            Class stringClass = Class.forName("java.lang.String");
            //使用Constructor方法获取所有构造方法
            Constructor[] constructors = stringClass.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //获取构造方法的修饰符
                int modifiers = constructor.getModifiers();
                //使用Modifier工具类的方法获得真实的修饰符并输出
                System.out.print(Modifier.toString(modifiers));
                //获取构造方法的名称,并输出
                String name = constructor.getName();
                System.out.print(" "+name+"(");
                //获取构造方法的参数类型
                Class[] parameterTypes = constructor.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i>0){
                        System.out.print(",");
                    }
                    //输出类型名称
                    System.out.print(parameterTypes[i].getName());
                }
                System.out.println(");");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
