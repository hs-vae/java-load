package com.hs_vae.IO.Filter;
//Date:2020.10.15
/*
 * FileFilter过滤器使用
 * 
 */
import java.io.File;

public class Demo1FileFilter {
	public static void main(String[] args) {
		File a=new File("//home//hs//eclipse-workspace//vae");
		getAllFile(a);
	}
    public static void getAllFile(File f1){
	File[] f2=f1.listFiles(new FileFilterImpl());   //传递了一个过滤器对象
	for(File f3:f2) {           
		if(f3.isDirectory()) {         //先判断一下是否为文件夹
			getAllFile(f3);            //如果是文件夹的话再次递归该方法打印目录下的文件
		}else {                        
	        	  System.out.println(f3);  //如果是文件夹则直接打印
	          }
		}
	}
	
    }
 
