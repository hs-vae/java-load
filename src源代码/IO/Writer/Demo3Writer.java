package com.hs_vae.IO.Writer;
//Date:2020.10.17
import java.io.FileWriter;
import java.io.IOException;
/*
     字符输出流写数据的其他方法:
         -void	write(com.hs_vae.String str, int off, int len)写一个字符串的一部分,off字符串的开始索引,len写的字符个数
         -void	write(char[] cbuf)写入字符数组
         -void  write(com.hs_vae.String str)写入字符串
 */
public class Demo3Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("f.txt");
        //1.写入字符串
        /*fw.write("你好");
        fw.flush();
        fw.close();*/

        /*//2.写入字符数组
        char[] s={'a','b','c'};
        fw.write(s);
        fw.flush();
        fw.close();*/

        //3.写入字符串的一部分
        fw.write("许嵩",0,2);
        fw.flush();
        fw.close();
    }
}
