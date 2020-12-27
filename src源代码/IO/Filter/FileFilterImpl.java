package com.hs_vae.IO.Filter;
import java.io.File;
import java.io.FileFilter;
/*
 * 创建过滤器FileFilter的实现类,重写过滤方法accept,定义过滤规则
 */
public class FileFilterImpl implements FileFilter{
	public boolean accept(File pathname) {
		if(pathname.isDirectory()) {
			return true;
		}
		return pathname.getName().toLowerCase().endsWith(".java");  //返回值先转换为字符串,并且转换为小写,再接受只带.java的文件
	}
}
