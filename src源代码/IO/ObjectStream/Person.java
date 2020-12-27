package com.hs_vae.IO.ObjectStream;
import java.io.Serializable;
/*
     序列化和反序列化的时候,会抛出NotSerializableException没有序列化异常
     类通过实现java.io.Serializable接口以启用其序列化功能,未实现此接口的类将无法使其任何状态序列化或反序列化
     Serializable接口也叫标记型接口
         要进行序列化和反序列化的类必须实现Serializable接口以启用其序列化功能,未实现此接口的类将无法使其任何状态序列化或反序列化
         当我们进行序列化和反序列化的时候,就会检测类上是否有这个标记
           有:就可以序列化和反序列化
           没有:就会抛出NotSerializableException异常
      static关键字:静态关键字
          静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
          被static修饰的成员变量不能被序列化,序列化的都是对象
          Person{name='许嵩', age=0}
      transient关键字:瞬态关键字
          被transient修饰成员变量,不能被序列化
          private transient int age;
 */
public class  Person implements Serializable {
    private static  final  long serialVersiouUID=1L; //可以解决序列化冲突异常
    private String name;
    public int age;
    public Person() {
    }

    public Person(String name,int age) {
        this.name = name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
