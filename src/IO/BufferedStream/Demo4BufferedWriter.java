package com.hs_vae.IO.BufferedStream;
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
