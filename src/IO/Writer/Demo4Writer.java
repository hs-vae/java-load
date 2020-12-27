package com.hs_vae.IO.Writer;
import java.io.FileWriter;
import java.io.IOException;
//Date:2020.10.17
/*
    字符输出流续写和换行,和字节是一样的
 */
public class Demo4Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("hello.txt",true); //append为true时,不会覆盖原文件,继续在末尾进行续写
        for (int i = 0; i < 10; i++) {
            fw.write("Hello World"+"\n");//本人用的是linux,所以换行符号写的是"\n",windows是"\r\n"
        }
        fw.flush();
        fw.close();
    }
}
