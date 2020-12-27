package com.hs_vae.IO.File;
import java.io.File;
import java.io.IOException;
//Date:2020.10.14
/*
 *    File类创建删除功能的方法
 *      public boolean creatNewFile():当且仅当具有该名称的文件尚不存在时,创建一个新的空文件
 *      public boolean delete():删除由此File表示的文件或目录
 *      public boolean mkdir():创建由此File表示的目录
 *      public boolean mkdirs():创建由此File表示的目录,包括任何必需但不存在的父目录
 */
public class Demo5FileModify {
	public static void main(String[] args) throws IOException {
		//showdelete();
		showCreateNewFile();
		//showmkdirs();
	}

	public static void showCreateNewFile() throws IOException{  
	//createNewFile声明抛出了IOException,我们调用这个方法,就必须处理这个异常,要么throws,要么trycatch
		File f1=new File("a1");        //相对路径
		System.out.println("是否创建文件:"+f1.createNewFile());	
	}
	public static void showdelete() {
		File f2=new File("a1");
		System.out.println("是否删除成功:"+f2.delete());
	}
	public static void showmkdirs() { 
		File f1=new File("11//22//33");    //可以在vae目录下在生成111//222//333多级目录
		System.out.println("创建多级文件夹是否成功:"+f1.mkdirs());
	}
	public static void showmkdir() {
		File f1=new File("bbb");
		System.out.println("创建单级文件夹是否成功:"+f1.mkdir());
	}
}
