<!-- toc -->

## 一、对象的序列化流ObjectOutputStream

先创建一个Person类,在下面

```java
package Demo4.Demo4.IOAndProperties.ObjectStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
//Date:2020.10.18
/*
     java.io.ObjectOutputStream extends OutputStream
     ObjectOutputStream:对象的序列化
     作用:把对象以流的方式写入到文件中保存

     构造方法:
         ObjectOutputStream(OutputStream out)创建写入指定的OutputStream的ObjectOutputStream
         参数:
             OutputStream out:字节输出流
     特有的成员方法:
         void writeObject(Object obj)将指定的对象写入ObjectOutputStream
 */
public class Demo1ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建ObjectOutputStream对象,构造方法中传递字节输出流
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("person.txt"));
        //2.使用ObjectOutputStream对象中的方法writeObject,吧对象写入到文件中
        oos.writeObject(new Person("许嵩",34));
        //3.释放资源
        oos.close();
    }
}

```

## 二、对象的反序列化流ObjectInputStream

```java
package Demo4.Demo4.IOAndProperties.ObjectStream;
//Date:2020.10.18
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
       java.io.ObjectInputStream extends InputStream
       ObjectInputStream:对象的反序列化流
       作用:把文件中保存的对象,以流的方式读取出来使用

       构造方法:
          ObjectInputStream(InputStream in)创建从指定InputStream读取的ObjectInputStream
          参数:
              InputStream in:字节输入流
       特有的成员方法:
          Object readObject()从ObjectInputStream读取对象
 */
public class Demo2ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.创建ObjectInputStream对象,构造方法中传递字节输入流
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("person.txt"));
        //2.使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        Object o=ois.readObject();
        //3.释放资源
        ois.close();
        //4.使用读取出来的对象(打印输出)
        System.out.println(o);
        Person  a=(Person)o;
        System.out.println(a.getName()+a.getAge());
    }
}

```

## 三、transien关键字和InvalidClassException异常原理

```java
package Demo4.Demo4.IOAndProperties.ObjectStream;
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
    public int age;   //修改private为public不报错
    
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
```



## 四、练习:序列化集合

```java
package Demo4.Demo4.IOAndProperties.ObjectStream;
//Date:2020.10.18
/*
      练习:序列化集合
          当我们想在文件中保存多个对象的时候
          可以把多个对象存储到一个集合中,对集合进行序列化和反序列化
 */
import java.io.*;
import java.util.ArrayList;
public class Demo3Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list=new ArrayList<>();
        //2.往ArrayList集合中存储Person对象
        list.add(new Person("许嵩",34));
        list.add(new Person("汪苏泷",30));
        list.add(new Person("周杰伦",45));
        //3.创建一个序列化流ObjectOuputStream对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("歌手.txt"));
        //4.使用ObjectOutputStream中的writeObject,对集合进行序列化
        oos.writeObject(list);
        //5.创建一个反序列化ObjectInputStream对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("歌手.txt"));
        //6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
         Object o=ois.readObject();
         //7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> list2=(ArrayList<Person>)o;
        //8.遍历ArrayList集合
        for (Person p : list2) {
            System.out.println(p);
        }
        //释放资源
        ois.close();
        oos.close();
    }
}

```

