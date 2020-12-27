package com.hs_vae.IO.CopyFile;
//Date:2020.10.16
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//Date:2020.10.16
/*
  文件复制:一读一写
  步骤:
      1.创建一个字节输入流对象,构造方法中绑定要读的数据源
      2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
      3.使用字节输入流对象中的read方法读取文件
      4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
 */
public class Demo1CopyFile {
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();
        FileInputStream fis=new FileInputStream("//home//hs//下载//dog.jpg");
        FileOutputStream fos=new FileOutputStream("dog.jpg");
        /*int len=0;
        while ((len =fis.read())!=-1){
            fos.write(len);
        }*/
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len =fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();
        long e=System.currentTimeMillis();
        System.out.println("复制共耗时:"+(e-s)+"毫秒");
    }
}
