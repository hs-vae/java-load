package com.hs_vae.IO.Filter;
import java.io.File;

//Date:2020.10.15
/*
 * 利用FilenameFilter接口实现过滤只留下.zip文件和.docx文件.
 */
public class Demo3FilenameFilter {
	public static void main(String[] args) {
		File f=new File("//home//hs//文档");
		getZipDocx(f);
	}
	//先定义一个方法,参数类型为File
	public static void getZipDocx(File f1) {
		/*
		//使用匿名内部类
		File[] f2=f1.listFiles(new FilenameFilter() {
			public boolean accept(File dir,com.hs_vae.String name) {
				//过滤规则为文件夹或者是以.zip和.docx结尾的文件
		       return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".zip")||name.toLowerCase().endsWith(".docx");
			}
		});*/
		//可以使用Lamda表达式进行优化匿名内部类(前提FilenameFilter接口只有一个accept方法)
		File[] f2=f1.listFiles((dir,name)->new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".docx")||name.toLowerCase().endsWith(".docx"));		
		//进行过滤后的遍历打印
		for(File f3:f2) {
			if(f3.isDirectory()) {
				getZipDocx(f3);           //如果是为文件夹则继续递归遍历打印
			}else {
				System.out.println(f3);   //如果是文件的话直接打印
			}
		}
	}
}


