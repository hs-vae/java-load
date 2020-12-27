package com.hs_vae.IO.ReverseStream;
//Date:2020.10.18
/*
      java.io.InputStreamReader extends Reader
      InputStreamReader:是字节流通向字符流的桥梁,可以指定的charset将要读取流中的字节编码字符(编码:把看不懂的变成看懂)
      继承自父类共性的成员方法,构造方法和前面也一样

      使用步骤:
        1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称
        2.使用InputStreamReader对象中的方法read读取文件
        3.释放资源
      注意:
         构造方法中指定的编码表名称要和文件的编码相同,否则会发生乱码
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class Demo3InputStreamReader {
    public static void main(String[] args) throws IOException {
        readutf8();
        readgbk();
    }

    private static void readutf8() throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("utf-8.txt"),"utf-8");
        int len=0;
        while ((len =isr.read())!=-1){
            System.out.print((char)len);
        }
        isr.close();
    }
    private static void readgbk() throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream("gbk.txt"),"gbk");
        int len=0;
        while ((len =isr.read())!=-1){
            System.out.print((char)len);
        }
        isr.close();
    }
}
