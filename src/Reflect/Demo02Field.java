package com.hs_vae.Reflect;
 /*
         获取成员变量们
         Field[] getFields() 获取所有public修饰的成员变量
         Field gerField(com.hs_vae.String name)
         Field[] getDeclaredFields()
         Field getDeclaredField(com.hs_vae.String name)
  */
import java.lang.reflect.Field;

public class Demo02Field {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //获取Person的Class对象
        Class personClass = Person.class;
        // Field[] getFields() 获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("-----------------------");
        // Field gerField(com.hs_vae.String name) 获取指定的public修饰的成员变量
        Field name = personClass.getField("name");
        Person person =new Person();
        Object o = name.get(person);
        System.out.println(o);     //null
        name.set(person,"许嵩");
        System.out.println(person); //Person{name='许嵩', age=0, a=0, sex=0.0, flag=false}
        System.out.println("------------------------");
        // Field[] getDeclaredFields() 获取所有的成员变量,不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("------------------------");
        // Field getDeclaredField(com.hs_vae.String name)
        Field age = personClass.getDeclaredField("age");
        //忽略访问权限修饰符的安全检查
        age.setAccessible(true);  //暴力反射
        Object o1 = age.get(person);
        System.out.println(o1);  //0
        age.set(person,10);
        System.out.println(person); //Person{name='许嵩', age=10, a=0, sex=0.0, flag=false}
    }
}
