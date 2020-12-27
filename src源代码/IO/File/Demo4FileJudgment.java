package com.hs_vae.IO.File;
import java.io.File;
//Date:2020.10.14
/*
 * File类判断功能的方法
 *        public boolean exists():此File表示的文件或目录是否实际存在
 *        public boolean isDirectory():此File表示的是否为目录
 *        public boolean isFile():此File表示的是否为文件
 * 注意:
 * 3个方法都是为布尔类型,存在输出:true,不存在输出:false
 * isDirectory方法和isFile方法首先判断一下这个文件或文件夹是否存在，在判断是否为目录或者文件
 */
public class Demo4FileJudgment {
	public static void main(String[] args) {
		show1();
		show2();
	}
	public static void show1() {
  	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");  
  		  System.out.println(f1.exists());
	}

	public static void show2() {
  	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
	  File f2=new File("//home//hs//eclipse-workspace//vae");
	  if(f1.exists()) {       //先判断这个文件或文件夹是否存在
		  System.out.println("f1是否为文件:"+f1.isFile());
		  System.out.println("f1是否为目录:"+f1.isDirectory());
	  }
	  if(f2.exists()) {
		  System.out.println("f2是否为文件:"+f2.isFile());
		  System.out.println("f2是否为目录:"+f2.isDirectory());
	  }
	}
}
