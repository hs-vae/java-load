package com.hs_vae.IO.PrintStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
//Date:2020.10.18
/*
     java.io.PrintStream:打印流
        PrintStream 为其他输出流添加了功能,使它们能够方便地打印各种数据值表示形式
     PrintStream特点:
        1.只负责数据的输出,不负责数据的读取
        2.与其他输出流不同,PrintStream永远不会抛出IOException
        3.有特有的方法,print,println
           void print(任意类型的值)
           void println(任意类型的值并换行)
        构造方法:
           PrintStream(File file):输出目的地是一个文件
           PrintStream(OutputStream out):输出的目的地是一个字节输出流
           PrintStream(com.hs_vae.String fileName):输出目的地是一个文件路径
        PrintStream extends OutputStream
        注意:
            如果使用继承自父类的write方法写数据那么查看数据的时候会查询编码表比如97->a
            如果使用自己特有的方法print/println方法写数据,写的数据原样输出97->97
 */
public class Demo1PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //创建打印流PrintStream对象,构造方法中绑定要输出目的地
        PrintStream ps=new PrintStream("print.txt");
        //如果使用继承自父类的write方法写数据那么查看数据的时候会查询编码表比如97->a
        ps.write(97);
        //如果使用自己特有的方法print/println方法写数据,写的数据原样输出97->97
        ps.println(97);
        //释放资源
        ps.close();
    }
}
