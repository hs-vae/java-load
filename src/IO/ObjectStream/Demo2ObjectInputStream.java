package com.hs_vae.IO.ObjectStream;
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
