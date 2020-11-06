<!-- toc -->

## FileInputStream简单使用

```java
package Demo4.Demo4.IOAndProperties.InputStream;
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
           FileInputStream(String name)
           FileInputStream(File file)
           参数:读取文件的数据源
               String name:文件的路径
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
        FileInputStream fis=new FileInputStream("hello.txt");  //hello.txt里面写了一个a
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
            System.out.println(len);        //输出97
        }
        fis.close();
    }
}

```

## FileInputStream一次读取多个字节

```java
package Demo4.Demo4.IOAndProperties.InputStream;
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
         String(byte[] bytes):把字节数组转换为字符串
         String(byte[] byte, int offset, int length):把字节数组的一部分转换为字符串  offset:数组的开始索引 length:转换的字节个数
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

```

## 综合案例:利用FileOutputStream和FileInputStream实现文件复制

```java
package Demo4.Demo4.IOAndProperties.CopyFile;
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
        long s=System.currentTimeMillis();  //可以定义变量s记录起始时间 
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
        long e=System.currentTimeMillis();  //变量e记录终止时间
        System.out.println("复制共耗时:"+(e-s)+"毫秒");   //输出完成复制需要多长时间
    }
}
```

