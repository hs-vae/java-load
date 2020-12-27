package com.hs_vae.IO.OutputStream;
//Date:2020.10.16
import java.io.FileOutputStream;
import java.io.IOException;
/*
           参数:写入数据的目的地
             com.hs_vae.String name：目的地是一个文件的路径
             File file：目的地是一个文件

           构造方法的作用:
             1.创建一个FileOutputStream对象
             2.会根据构造方法中传递的文件/文件路径,创建一个空的文件
             3.会把FileOutputStream对象指向创建好的文件

           写入数据的原理(内存-->硬盘)
             java程序-->JVM(java虚拟机)-->OS(操作系统)-->OS调用写数据的方法-->把数据写入到文件中

           字节输出流的使用步骤(重点):
             1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
             2.调用FileOutputStream对象中的方法write,把数据写入到文件中
             3.释放资源(流使用会占用一定的内存,使用完毕记得要把内存清空,提高程序的效率)
 */
public class Demo1OutputStream {
    public static void main(String[] args) throws IOException {
        //1.创建一个FileOutputStream对象,构造方法中传递写入数据的目的地
        FileOutputStream fos=new FileOutputStream("hello.txt");  //使用一个相对路径
        //2.调用FileOutputStream对象中的方法write,把数据写入到文件中
        fos.write(97);
        /*
        把数据97由内存写入到硬盘的a.txt文件中
        写数据的时候,会把10进制的整数转换为二进制整数即97-->1100001,
        硬盘存储的数据都是字节，相当于硬盘存储了97的二进制数1100001,1字节=8比特位(10101010)
        注意:
            任意的文本编辑器(记事本,notepad++)
            在打开文件的时候都会查询编码表,把字节转换为字符表示
            0~127:会查询ASCLL码表
            其他值:会查询系统默认码表(中文系统GBK)
        所以a.txt文件显示的是小写字母a
         */
        //3.释放资源(流使用会占用一定的内存,使用完毕记得要把内存清空,提高程序的效率)
        fos.close();
    }
}
