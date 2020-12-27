package com.hs_vae.IO.Writer;
//Date:2020.10.17
import java.io.FileWriter;
import java.io.IOException;
/*
   flush方法和close方法的区别:
      -flush:刷新缓冲区,流对象可以继续使用
      -close:先刷新缓冲区,然后通知系统释放资源,流对象不可以再使用
 */
public class Demo2CloseAndFlush {
    public static void main(String[] args) throws IOException {
        FileWriter fw=new FileWriter("c.txt");
        fw.write(97);
        fw.flush();
        fw.write(98);    //flush之仍然流对象可以继续使用
        fw.write(999);
        fw.close();
        // fw.write(99);   注意close之后就不能再使用流对象了
    }
}
