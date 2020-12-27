package com.hs_vae.IO.BufferedStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//Date:2020.10.18
/*
       字符缓冲输入流和前面使用是一样的
       但是BufferedReader特有一个成员String readLine()方法
       com.hs_vae.String readLine()方法:读取一个文本行即就是读取一行数据
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
