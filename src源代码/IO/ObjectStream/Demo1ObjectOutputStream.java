package com.hs_vae.IO.ObjectStream;
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
