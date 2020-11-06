<!-- toc -->

## 一、Properties集合概述和简单使用

```java
package Demo4.Demo4.IOAndProperties.Properties;
import java.util.Properties;
import java.util.Set;
//Date:2020.10.17
/*
        java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
        Properties类表示了一个持久的属性集.Properties可保存在流中或从流中加载。
        Properties集合是一个唯一和IO流相结合的集合
             可以使用方法store把集合中的临时数据持久化写入硬盘中存储
             可以使用方法load把硬盘保存的文件(键值对),读取到集合中使用
        属性列表中每个键及其对应值都是一个String字符串
             Properties集合是一个双列集合,key和value默认都是字符串
 */
public class Demo1Properties {
    public static void main(String[] args) {
        show1();
    }
    /*
           使用Properties集合存储数据,遍历取出Properties集合中的数据
           Properties集合是一个双列集合,key和value默认都是字符串
           Properties集合有一些操作字符串的特有方法
               Object setProperty(String key,String value)调用Hashtable的方法put
               String getProperty(String key)通过key找到value值,此方法相当于Map集合中的get(key)方法
               Set<String> stringPropertyNames()返回此属性列表中的键集,其中该键及其对应值是字符串,此方法相当于Map集合中的keySet方法
     */
    private static void show1() {
        Properties prop=new Properties();
        prop.setProperty("许嵩","有何不可");
        prop.setProperty("周杰伦","一路向北");
        prop.setProperty("汪苏泷","万有引力");

        //使用stringPropertyNames把Properties集合中的键取出,存储到一个set集合中
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {     //使用foreach遍历
            String value = prop.getProperty(key);   //通过key找到value的值
            System.out.println(key+":"+value);
        }

    }

}

```

## 二、Properties集合中的store方法

```java
package Demo4.Demo4.IOAndProperties.Properties;
//Date:2020.10.17
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
     可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
     void store(OutputStream out,String comments)
     void store(Writer writer,String comments)
     参数：
         OutputStream out:字节输出流,但是注意不能写入中文
         Writer writer:字符输出流,可以写中文
         String comments:注释,用来解释说明保存的文件是做什么用的
                  不能使用中文,会产生乱码,默认是Unicode编码
                  一般使用""空字符串
      使用步骤:
          1.创建Properties集合对象,添加数据
          2.创建字节输出流/字符输出流对象,构造方法中绑定要输出的目的地
          3.使用Properties集合中的方法store
 */
public class Demo2PropertiesStore {
    public static void main(String[] args) throws IOException {
        show2();
    }
    private static void show2() throws IOException {
        FileWriter fw=new FileWriter("我是歌手.txt");
        Properties prop=new Properties();
        prop.setProperty("许嵩","有何不可");
        prop.setProperty("汪苏泷","万有引力");
        prop.setProperty("周杰伦","一路向北");
        prop.store(fw,"Singer");
        //prop.store(new FileOutputStream("singer"),"Singer");  //字节输出流识别不了中文,会产生乱码的
        fw.close();
    }
}

```

## 三、Properties集合中的load方法

```java
package Demo4.Demo4.IOAndProperties.Properties;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
/*
     可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用
     void load(InputStream inStream)
     void load(Reader reader)
     参数:
         InputStream inStream:字节输入流,不能读取含有中文的键值对
         Reader reader:字符输入流,能读取含有中文的键值对
     使用步骤:
         1.创建Properties集合对象
         2.使用Properties集合对象中的方法load读取保存键值对的文件
         3.遍历Properties集合
      注意:
         1.存储键值对的文件中,键与默认值的连接符号可以使用=,空格(其他符号)
         2.存储键值的文件中,可以使用#进行注释,被注释的键值对不会再被读取
         3.存储键值对的文件中,键与值默认都是字符串,不用再加引号
 */
public class Demo3PropertiesLoad {
    public static void main(String[] args) throws IOException {
        show3();
    }
    private static void show3() throws IOException {
        Properties prop=new Properties();
        prop.load(new FileReader("我是歌手.txt"));     //使用字符输入流读取文件,因为它能读取中文,而字节输入流不行
        Set<String> set = prop.stringPropertyNames();          //返回集合列表中的键值[周杰伦, 汪苏泷, 许嵩]
        System.out.println(set);              //[周杰伦, 汪苏泷, 许嵩]
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }
}
```

