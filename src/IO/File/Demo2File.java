package com.hs_vae.IO.File;
//Date:2020.10.14
/*
 * 绝对路径:是一个完整的路径，就linux而言从根目录开始,windows从盘符开始
 *      linux举例:
 *      //home//hs//eclipse-workspace//vae//src//Advanced.Demo4IO//Demo2File
 *      windous举例：
 *      c:\\Users\\itcast
 * 相对路径:是一个简化的路径
 *       相对指的是相对于当前项目的根目录(//home//hs//eclipse-workspace//vae//src//Advanced.Demo4IO)
 *       如果使用当前项目的根目录,路径可以简化写为:
 *       //home//hs//eclipse-workspace//vae//src//Advanced.Demo4IO//123.txt-->123.txt
 * 注意：
 *    1.路径是不区分大小写
 *    2.路径中的文件名称分隔符linux使用正斜杠，正斜杠是转义字符，两个正斜杠代表一个普通的正斜杠
 */
import java.io.File;
public class Demo2File {
	public static void main(String[] args) {
		show1();
		show2("//home//hs","123.txt");
		show3();
	}
	
	public static void show1() {
		File f1=new File("//hs//home//eclipse-workspace//vae//src//Advanced.Demo4IO//123.txt");  //路径以文件结尾,绝对路径
		System.out.println(f1);
		File f2=new File("//hs//home//eclipse-workspace//vae//src//Advanced.Demo4IO");           //路径以目录结尾，绝对路径
		System.out.println(f2);
		File f3=new File("123.txt");
		System.out.println(f3);              //以相对路径结尾
	}
	
	public static void show2(String parent,String child) {       //根据parent路径字符串和child路径字符串创建一个新的File实例
		File file=new File(parent,child);
		System.out.println(file);
	}
	
	public static void show3() {            //和第二种方法相似,但父路径参数类型为File类型,这样好处就是可以调用File方法
		File parent=new File("//home//hs");
		File file=new File(parent,"123.txt");
		System.out.println(file);
	}
}
