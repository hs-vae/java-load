<!-- toc -->

## OutputStream是一个顶级父类,但是它是抽象类,不能直接使用,只能使用它的子类,主要学习FileOutputStream子类

### 定义了一些子类共性的方法

| Modifier and Type | Method and Description                                       |
| :---------------- | :----------------------------------------------------------- |
| `void`            | `close()`关闭此输出流并释放与此流相关联的任何系统资源。      |
| `void`            | `flush()`刷新此输出流并强制任何缓冲的输出字节被写出。        |
| `void`            | `write(byte[] b)`将 `b.length`字节从指定的字节数组写入此输出流。 |
| `void`            | `write(byte[] b, int off, int len)`从指定的字节数组写入 `len`个字节，从偏移 `off`开始输出到此输出流。 |
| `abstract void`   | `write(int b)`将指定的字节写入此输出流。                     |

FileOutputStream:文件字节输出流

java.io.FileOutputStream extends OutputStream继承了它的父类

作用:把内存中的数据写入到硬盘中

| Constructor and Description                                  |
| :----------------------------------------------------------- |
| `FileOutputStream(File file)`创建文件输出流以写入由指定的 `File`对象表示的文件。 |
| `FileOutputStream(File file, boolean append)`创建文件输出流以写入由指定的 `File`对象表示的文件。 |
| `FileOutputStream(FileDescriptor fdObj)`创建文件输出流以写入指定的文件描述符，表示与文件系统中实际文件的现有连接。 |
| `FileOutputStream(String name)`创建文件输出流以指定的名称写入文件。 |
| `FileOutputStream(String name, boolean append)`创建文件输出流以指定的名称写入文件。 |

### FileOutputStream简单使用

```java
package Demo4.Demo4.IOAndProperties.OutputStream;
//Date:2020.10.16
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/*
           参数:写入数据的目的地
             String name：目的地是一个文件的路径
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
```

### FileOutputStream一次写入多个字节

```java
package Demo4.Demo4.IOAndProperties.OutputStream;
//Date:2020.10.16
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
/*
     一次写入多个字节的方法:
         -public void write(byte[] b)将 b.length字节从指定的字节数组写入此输出流
         -public void write(byte[] b, int off, int len)从指定的字节数组写入len个字节,从偏移off开始输出到此输出流
 */
public class Demo2OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream(new File("b.txt"));
        byte[] bytes={65,66,67,68,69};
        fos.write(bytes);
         /*
         write(byte[] b,int off,int len):从指定的字节数组写入len个字节，从偏移off开始输出到此输出流
              off:数组的开始索引值
              len:写入字节的个数
          */
        fos.write(bytes,1,2);   //从索引值为1即66开始写入，写2个，写入了66和67，所以显示的是B，C
        /*
          写入字符的方法,可以使用String类中的方法把字符串转换为字节数组
                byte[] getBytes() 把字符串转换为字节数组
         */
        byte[] bytes2="你好".getBytes();
        System.out.println(Arrays.toString(bytes2));  //打印bytes2数组：[-28, -67, -96, -27, -91, -67]
        fos.write(bytes2);
        fos.close();
    }
}

```

### FileOutputStream追加写/续写

```java
package Demo4.Demo4.IOAndProperties.OutputStream;
//Date:2020.10.16
import java.io.FileOutputStream;
import java.io.IOException;
/*
        追加写/续写:使用两个参数的构造方法
        FileOutputStream(String name, boolean append)创建文件输出流以指定的名称写入文件
        FileOutputStream(File file, boolean append)创建文件输出流以写入由指定的 "File"对象表示的文件
        参数
            String name,File file:写入数据的目的地
            boolean append:追加写开关
              true:创建对象不会覆盖源文件,继续在文件的末尾追加写数据
              false:创建一个新文件,覆盖原文件
        写换行:写换行符号
             windows:\r\n
             linux:\n
             mac:/r
 */
public class Demo3OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("e.txt",true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好".getBytes());
            fos.write("\n".getBytes());
        }
        fos.close();
    }
}

```

