<!-- toc -->

## 一、字节缓冲流

### 1.字节输入缓冲流

```java
package Demo4.Demo4.IOAndProperties.BufferedStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Date:2020.10.18
public class Demo1BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("b.txt");
        //创建BufferedInputStream对象,方法中传递FileInputStream对象,提高FileInputStream对象的读取效率
        BufferedInputStream bis =new BufferedInputStream(fis);
        int len=0;
        //创建一个字节数组进一步提高读取效率
        byte[] bytes=new byte[1024];
        while ((len = fis.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len)); //byte类型转换为字符串类型
        }
        bis.close();
    }
}

```

### 2.字节输出缓冲流

```java
package Demo4.Demo4.IOAndProperties.BufferedStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//Date:2020.10.18
public class Demo2BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fis=new FileOutputStream("01.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fis);
        fis.write("字节缓冲输出流".getBytes());   //字符串转换为字节调用getBytes方法
        bos.close();
    }
}

```

### 3.缓冲流的效率测试(文件复制)

```java
package Demo4.Demo4.IOAndProperties.CopyFile;
import java.io.*;
/*
    借助缓冲字节流实现复制文件,极高的提高效率!
 */
//Date:2020.10.18
public class Demo2BufferedCopyFile {
    public static void main(String[] args) throws IOException {
        long s=System.currentTimeMillis();  //记录运行的初始时间
        //可以使用匿名内部类
        BufferedInputStream bis=new BufferedInputStream(new FileInputStream("//home//hs//下载//dog.jpg"));
        BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream("do.jpg"));
        int len= 0;
        byte[] bytes=new byte[1024];     //利用字节数组再次提高效率
        while ((len =bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
        long e=System.currentTimeMillis();
        System.out.println("复制共耗时:"+(e-s)+"毫秒"); //只需要1毫秒,非常快
    }
}

```

## 二、字符缓冲流

### 1.字符缓冲输入流

```java
package Demo4.Demo4.IOAndProperties.BufferedStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Date:2020.10.18
/*
       字符缓冲输入流和前面使用是一样的
       但是BufferedReader特有一个成员String readLine()方法
       String readLine()方法:读取一个文本行即就是读取一行数据
            行的终止符号为:换行'\n'  回车'\r' 回车后接着换行'\r\n'
           返回值:
              包含该行内容的字符串,不包含任何终止符,
              如果到达流末尾返回null而不是-1,这是和前面不同的区别
 */
public class Demo3BufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("许嵩.txt"));
        String nextline;
        while ((nextline =br.readLine())!=null){
            System.out.println(nextline);
        }
    }
}

```

### 2.字符缓冲输出流

```java
package Demo4.Demo4.IOAndProperties.BufferedStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
//Date:2020.10.18
public class Demo4BufferedWriter {
    public static void main(String[] args) throws IOException {
        //写入名为"许嵩.txt"文件,并开启续写
        BufferedWriter bw=new BufferedWriter(new FileWriter("许嵩.txt",true));
        for (int i = 0; i < 10; i++) {
            bw.write("最佳歌手");   //写入字符串"最佳歌手"
            bw.newLine();  //可以使用BufferedWriter中newLine方法进行换行
        }
        bw.close();
    }
}

```

### 3.练习:对文本内容进行排序

```java
package Demo4.Demo4.IOAndProperties.BufferedStream;
import java.io.*;
import java.util.HashMap;
//Date:2020.10.18
public class Demo5SortTest {
    public static void main(String[] args) throws IOException {
        //1.创建一个HashMap集合对象,可以存储每行文本的序号(1,2,3等等);value:存储每行的文本
        HashMap<String,String> map=new HashMap<>();
        //2.创建字符缓冲输入对象,构造方法中绑定字符输入流
        BufferedReader br=new BufferedReader(new FileReader("许嵩.txt"));
        //3.创建字符缓冲输出对象,构造方法中绑定字符输出流
        BufferedWriter bw=new BufferedWriter(new FileWriter("排序好的许嵩.txt"));
        //4.使用字符输入缓冲流中的readline,逐行读取文本
        String line;
        while ((line = br.readLine())!=null){
            //5.对读取的文本进行切割,获取行的序号和文本内容
            String[] arr= line.split("\\.");  //   以.进行切割这里需要使用转义字符\\.
            //6.把切割好的序号和文本内容存储到HashMap集合中(key序号是有序的,会自动排序1,2,3)
            map.put(arr[0],arr[1]);     //注意如果文本里面有单独一行的空格会报错空指针异常
        }
        //7.遍历HashMap集合,获取每一个键值对
        for (String key : map.keySet()) {
             String value=map.get(key);
             //8.把每一个键值对,拼接为一个文本行
             line=key+"."+value;
             //9.把拼接好的文本,使用字符缓冲输出流中的方法write,写入到文件中
            bw.write(line);
            bw.newLine();    //写一个换行,因为readLine返回值包含该行内容的字符串不包含任何终止符
        }
        //10.释放资源
        br.close();
        bw.close();
    }
}
```

