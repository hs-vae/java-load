package com.hs_vae.IO.OutputStream;
//Date:2020.10.16
import java.io.File;
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
