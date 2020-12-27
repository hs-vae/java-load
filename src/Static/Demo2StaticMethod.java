package com.hs_vae.Static;
/*
     一旦使用了static修饰成员方法,那么这就成为了静态方法,静态方法不属于对象,而是属于类的

     如果没有static关键字,那么必须首先创建对象,然后通过对象才能使用成员方法
     如果有static关键字,那么不需要创建对象,直接通过类名称来使用它

     无论是成员变量,还是成员方法,如果有了static,都推荐使用类名称进行调用
     静态变量:类名称.静态变量
     静态方法:类名称.静态方法

     注意:
     1.静态不能直接访问非静态,因为在内存当中先有的静态内容,后有非静态的内容
     2.静态方法当中不能用this
 */
public class Demo2StaticMethod {
    public static void main(String[] args) {
        //首先创建对象
        MyClass one=new MyClass();
        //然后才能使用没有static修饰的内容
        one.Method();

        //对于静态方法来说,可以通过对象名进行调用,也可以直接通过类名称来调用
        one.StaticMethod();      //可以这样写但是不推荐
        MyClass.StaticMethod();
    }
}
