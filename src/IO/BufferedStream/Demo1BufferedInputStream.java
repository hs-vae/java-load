package com.hs_vae.IO.BufferedStream;
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
