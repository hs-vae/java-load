package com.hs_vae.IO.ReverseStream;
//Date:2020.10.18
/*
      java.io.OutputStreamWriter extends Writer
      OutputStreamWriter:是字符流通向字节流的桥梁,可以指定的charset将要写入流中的字符编码成字节(编码:把看懂的变成看不懂)
      继承自父类共性的成员方法,构造方法和前面也一样

      使用步骤：
         1.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称(不指定的话默认是utf-8,可以大写也可以小写)
         2.使用方法write,把字符转换为字节存储缓冲区中(编码)
         3.使用方法flush,把内存缓冲区的字节刷新到文件中(使用字节流写字节的过程)
         4.释放资源
 */
import java.io.*;
public class Demo2OutputStreamWriter {
    public static void main(String[] args) throws IOException {
         writeutf8();   //能够显示出来"你好"
         writegbk();   //linux系统默认编码是utf-8,所以在外面看这个gbk.txt文件也是乱码的
    }

    private static void writegbk() throws IOException {
        //1.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称(可以大写也可以小写)
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("gbk.txt"),"gbk");
        //2.使用方法write,把字符转换为字节存储缓冲区中(编码)
        osw.write("你好");
        //3.使用方法flush,把内存缓冲区的字节刷新到文件中(使用字节流写字节的过程)
        osw.flush();
        //4.释放资源
        osw.close();
    }

    private static void writeutf8() throws IOException {
        //1.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称(可以大写也可以小写)
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("utf-8.txt"),"utf-8");
        //2.使用方法write,把字符转换为字节存储缓冲区中(编码)
        osw.write("你好");
        //3.使用方法flush,把内存缓冲区的字节刷新到文件中(使用字节流写字节的过程)
        osw.flush();
        //4.释放资源
        osw.close();
    }
}
