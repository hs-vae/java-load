package com.hs_vae.IO.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

//Date:2020.10.18
/*
      可以改变输出语句的目的地(打印流的流向)
      输出语句,默认在控制台输出
      使用System.setOut方法改变输出语句目的地改为参数中传递的打印流的目的地
         static void setOut(PrintStream out)
            重新分配"标准"输出流
 */
public class Demo2PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我在控制台输出哦");
        PrintStream ps=new PrintStream("目的地.txt");
        System.setOut(ps);
        System.out.println("我现在在目的地.txt中输出哦");
        ps.close();
    }
}
