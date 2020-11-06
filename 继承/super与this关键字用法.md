<!-- toc -->

## 一、super关键字用法

super关键字的用法有三种:

1.在子类的成员方法中,访问父类的成员变量

2.在子类的成员方法中,访问父类的成员方法

3.在子类的构造方法中,访问父类的构造方法

## 二、this关键字用法

super关键字用来访问父类内容,而this关键字用来访问本类内容.用法也有三种
1.在本类的成员方法中,访问本类的成员变量
2.在本类的成员方法中,访问本类的另一个成员方法
3.在本类的构造方法中,访问本类的另一个构造方法
第三种方法注意:
          a.this(...)调用也必须是构造方法的第一个语句,唯一一个.
          b.super和this两种构造调用,不能同时使用

## 三、实现结果

```java
//Fu.java  父类
package Basis.Demo7Extends.Demo6;
/*
       super关键字用来访问父类内容,而this关键字用来访问本类内容.用法也有三种
       1.在本类的成员方法中,访问本类的成员变量
       2.在本类的成员方法中,访问本类的另一个成员方法
       3.在本类的构造方法中,访问本类的另一个构造方法
       第三种方法注意:
                 a.this(...)调用也必须是构造方法的第一个语句,唯一一个.
                 b.super和this两种构造调用,不能同时使用
 */
public class Fu {
    int num=10;
    public void method(){
        System.out.println("父类的成员方法");
    }
}

//Zi.java 子类
package Basis.Demo7Extends.Demo6;
/*
     super关键字的用法有三种:
     1.在子类的成员方法中,访问父类的成员变量
     2.在子类的成员方法中,访问父类的成员方法
     3.在子类的构造方法中,访问父类的构造方法
 */
public class Zi extends Fu {
      int num=20;
      public void methodZi(){
          System.out.println(super.num);
      }
      public void method() {
        super.method();  //访问父类的method
        System.out.println("子类方法");
      }
      public Zi(){
          super();
      }
      public void showNum(){
          int num=30;
          System.out.println(num);  //访问局部变量num,直接写   30
          System.out.println(this.num);  //访问本类Zi成员变量num  20
          System.out.println(super.num); //访问父类成员变量num  10
      }

}

//Demo1Super.java  主类
package Basis.Demo7Extends.Demo6;
public class Demo1Super {
    public static void main(String[] args) {
        Zi zi=new Zi();
        zi.showNum();
        zi.method();
    }
}

//运行结果
30
20
10
父类的成员方法
子类方法
```

