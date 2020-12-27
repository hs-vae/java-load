package com.hs_vae.IO.BufferedStream;
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
