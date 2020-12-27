package com.hs_vae.IO.Recursion;
//Date:2020.10.15
/*
 * 综合案例:文件搜索
 * 前提条件,只要.java结尾的文件
 */
import java.io.File;
public class Demo3Recurison {
	public static void main(String[] args) {
		File a=new File("//home//hs//eclipse-workspace//vae");
		getAllFile(a);
	}
    public static void getAllFile(File f1){           
	File[] f2=f1.listFiles();          //将f1文件目录以数组的形式赋值给f2
	for(File f3:f2) {           
		if(f3.isDirectory()) {         //先判断一下是否为文件夹
			getAllFile(f3);            //如果是文件夹的话再次递归该方法打印目录下的文件
		}else {
			/*方法一
			  //因为f2为File类型,所以得转换为String类型
	          com.hs_vae.String name=f3.getName();
	          boolean b=name.endsWith(".java");    //字符串类可以调用endsWith方法判断是否为.java类型
	          if(b) {
	        	  System.out.println(name);
	          }
	          */
			
			/*方法二
			 * 可以用链式编程
			 */
	          if(f3.getName().toLowerCase().endsWith(".java")) {   //其中.toLowerCase()方法是将字符串转换为小写,不管.java类型文件名称是大写最终还是可以打印出来
	        	  System.out.println(f3);
	          }
		}
	}
	
    }
}
