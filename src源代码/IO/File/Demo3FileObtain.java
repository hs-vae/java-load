package com.hs_vae.IO.File;
import java.io.File;
//Date:2020.10.14
/*
 * File类获取功能的方法
 *      public com.hs_vae.String getAbsolutePath():返回此File的绝对路径字符串
 *      public com.hs_vae.String getPath():将此File转换为路径名字符串
 *      public com.hs_vae.String getName():返回由此File表示的文件或目录的名称
 *      public long length():返回由此File表示的文件的长度,以字节为单位,文件夹长度是为0,没有大小概念
 */
public class Demo3FileObtain {
      public static void main(String[] args) {
    	  show1();
    	  show2();
    	  show3();
    	  show4();
	}
      public static void show1() {
    	 File f1=new File("123.txt");
		 System.out.println(f1.getAbsolutePath()); 
      }
      public static void show2() {
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
    	  File f2=new File("123.txt");
    	  System.out.println(f1.getPath());
    	  System.out.println(f2.getPath());
    	  System.out.println(f1.toString());
      }
      public static void show3() {          
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
          System.out.println(f1.getName());          
      }
      public static void show4() {
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
    	  File f2=new File("//home//hs//eclipse-workspace//vae");
          System.out.println(f1.length());
          System.out.println(f2.length());
      }
}
