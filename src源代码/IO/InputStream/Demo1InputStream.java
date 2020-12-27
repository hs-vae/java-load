package com.hs_vae.IO.InputStream;
//Date:2020.10.16
import java.io.FileInputStream;
import java.io.IOException;

/*
      java.io.InuputStream:字节输入流
      此抽象类是表示输入流的所有类的超类

      定义了所有子类共性的方法:
          int read():从输入流读取数据的下一个字节。
          int read(byte[] b):从输入流读取一些字节数，并将它们存储到缓冲区数组b中
          void	close():关闭此输入流并释放与流相关联的任何系统资源
      java.io.FileInputStream extends InputStream
      FileInputStream:文件字节输入流
      作用:把硬盘文件中的数据,读取到内存中使用

      构造方法:
           FileInputStream(com.hs_vae.String name)
           FileInputStream(File file)
           参数:读取文件的数据源
               com.hs_vae.String name:文件的路径
               File file:文件
       读取数据的原理(硬盘-->内存)
           java程序-->JVM-->OS-->OS读取数据的方法-->读取文件
       字节输入流的使用步骤(重点):
           1.创建FileInputStream对象,构造方法中绑定要读取的数据源
           2.使用FileInputStream对象中的方法read,读取文件
           3.释放资源

 */
public class Demo1InputStream {
    public static void main(String[] args) throws IOException {
        //1.创建FileInputStream对象,构造方法中绑定要读取的数据源
        FileInputStream fis=new FileInputStream("hello.txt");
        //2.使用FileInputStream对象中的read方法,读取文件的末尾返回-1
        /*int s1=fis.read();
        int s2 = fis.read();
        int s3 = fis.read();
        int s4 = fis.read();
        System.out.println(s1);   //97 a
        System.out.println(s2);   //98 b
        System.out.println(s3);   //99 c
        System.out.println(s4);   //读完3个字节后返回-1
        //3.释放资源
        fis.close();*/
        /*
           可以使用循环进行优化，循环次数不确定用while，只要确定循环条件
           注意:
           必须先定义一个变量用于记录读取到的字节,read读完当前字节后会将指针指向下一个字节,否则它不会指向下一个字节默认读取完第一个字节后输出-1结束

         */
        int len=0;
        while((len =fis.read())!=-1){
            System.out.println(len);
        }
        fis.close();
    }
}
