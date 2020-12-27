package com.hs_vae.IO.InputStream;
//Date:2020.10.16
import java.io.FileInputStream;
import java.io.IOException;

/*
     字节输入流一次读取多个字节的方法:
         int read(byte[] b):从输入流读取一些字节数，并将它们存储到缓冲区数组b中
     注意:
         方法的参数byte[]的作用:起到缓冲的作用，存储每次读取到的多个字节
         方法的返回值int:每次读取的有效字节个数
     String类的构造方法
         com.hs_vae.String(byte[] bytes):把字节数组转换为字符串
         com.hs_vae.String(byte[] byte, int offset, int length):把字节数组的一部分转换为字符串  offset:数组的开始索引 length:转换的字节个数
 */
public class Demo2InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("b.txt");
//        byte[] bytes=new byte[2];
//        int num = fis.read(bytes);   //num获取每次读取的个数
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len =fis.read(bytes))!=-1){
            System.out.println(len);
            System.out.println(new String(bytes,0,len));  //使用String类将字节数组转换为字符串,从数组索引值0开始到字节总个数索引结束。
        }
          fis.close();
    }
}
