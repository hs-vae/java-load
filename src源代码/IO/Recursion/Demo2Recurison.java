package com.hs_vae.IO.Recursion;
import java.io.File;
//Date:2020.10.15
/*
 * 递归打印多级目录
 */
public class Demo2Recurison {
	public static void main(String[] args) {
		File a=new File("//home//hs//文档");
		getAllFile(a);
	}
	//定义一个方法，参数传递File类型的目录,方法中对目录进行遍历
    public static void getAllFile(File f1) {
    	System.out.println(f1);            //打印f1本身自己的目录
    	File[] f2=f1.listFiles();          //将f1文件目录以数组的形式赋值给f2
    	for(File f3:f2) {           
    		if(f3.isDirectory()) {         //先判断一下是否为文件夹
    			getAllFile(f3);            //如果是文件夹的话再次递归该方法打印目录下的文件
    		}else {
    			System.out.println(f3);    //如果是文件那么直接输出
    		}
    	}
    }
}
