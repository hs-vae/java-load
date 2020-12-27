package com.hs_vae.IO.BufferedStream;
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
