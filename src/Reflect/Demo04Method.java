package com.hs_vae.Reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
     案例:获取String类的成员方法
     获取成员方法们:
        Method[] getMethods()   获取所有public修饰的成员方法
        Method getMethod(com.hs_vae.String name,类<?>...parameterTypes) 获取指定的public修饰的成员方法
        Method[] getDeclaredMethods()
        Method  getDeclaredMethod(com.hs_vae.String name,类<?>...parameterTypes)
     Method类的常用方法
        com.hs_vae.String getName() 返回方法的名称
        Class[] getParameterTypes()  返回当前方法的参数类型
        int getModifiers() 返回修饰符的整型标识
        Class getReturnType()  返回当前的返回值类型
 */
public class Demo04Method {
    public static void main(String[] args) {
        try {
            //获取String类对象
            Class clazz = Class.forName("java.lang.String");
            //返回所有public修饰的的成员方法
            Method[] mtd = clazz.getMethods();
            for (Method method : mtd) {
                //获取方法的修饰符
                int modifiers = method.getModifiers();
                //使用Modifier工具类的方法获得真实的修饰符,并输出
                System.out.print(Modifier.toString(modifiers));
                //获取方法的返回值类型,并输出
                Class returnType = method.getReturnType();
                System.out.print(" "+returnType.getName());
                //获取方法的名称,并输出
                System.out.print(" "+method.getName()+"(");
                //获取方法的参数类型
                Class[] parameterTypes = method.getParameterTypes();
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
