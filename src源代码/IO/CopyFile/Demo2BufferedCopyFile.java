package com.hs_vae.IO.CopyFile;
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
