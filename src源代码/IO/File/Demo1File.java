package com.hs_vae.IO.File;
//Date:2020.10.14
import java.io.File;
public class Demo1File {
	public static void main(String[] args) {
		 String pathseparator=File.pathSeparator;
		 System.out.println(pathseparator);    //路径分隔符 windows:分号； linux:冒号:		 
		 String separator=File.separator;
		 System.out.println(separator);       //文件名称分隔符  windows:反斜杠\   linux:正斜杠:/		 
	}
}
