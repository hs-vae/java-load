package com.hs_vae.IO.File;
import java.io.File;
//Date:2020.10.14
/*
 *    File类遍历(文件夹)目录功能
 *     -public com.hs_vae.String[] list():返回一个String数组,表示该File目录中的所有子文件或目录。隐藏的文件夹也可以输出
 *     -public File[] listFiles():返回一个File数组,表示该File目录中的所有的子文件或目录
 * 注意:
 *     list方法和listFiles方法遍历的是构造方法中给出的目录
 *     如果构造方法中给出的目录的路径不存在,会抛出空指针异常
 *     如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
 */
public class Demo6FileTraverse {
	public static void main(String[] args) {
		showlist();
		showlistFiles();
	}
    public static void showlist() {
    	File  f1=new File("//home//hs//eclipse-workspace//vae");
    	String[] filename=f1.list();
    	for(String a:filename) {
    		System.out.println(a);
    	}
    }
    public static void showlistFiles() {
    	File  f1=new File("//home//hs//eclipse-workspace//vae");
    	File[] filename=f1.listFiles();
    	for(File a:filename) {
    		System.out.println(a);
    	}
    } 
    
     
}
