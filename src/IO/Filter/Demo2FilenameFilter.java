package com.hs_vae.IO.Filter;
/*
* FilenameFilter过滤器使用以及Lambda表达式优化匿名内部类(因为它只有一个accept方法)
*/
import java.io.File;

public class Demo2FilenameFilter {
	public static void main(String[] args) {
		File a=new File("src");
		getAllFile(a);

	}
	/*
	 * 定义一个方法，参数传递File类型的目录，方法中对目录进行遍历
	 */
   public static void getAllFile(File f1){ 
	   //传递过滤器对象,使用匿名内部类
	   //使用FileFilter接口
	   /*File[] f2=f1.listFiles(new FileFilter(){
	   public boolean accept(File pathname) {
			//过滤规则pathname是文件夹或者是.java结尾的文件返回true
			return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");
		}
	});*/
	   /*
	   //使用Lambda表达式优化匿名内部类(前提接口中只有一个抽象方法)
	   File[] f2=f1.listFiles(( File pathname)->{
		    return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");
	   });*/
	   /*还可以进一步优化
	   File[] f2=f1.listFiles((pathname)->(pathname).isDirectory()||pathname.getName().toLowerCase().endsWith(".java"));
	   */
	   /*
	   //使用FilenameFilter接口，同样使用匿名内部类
	   File[] f2=f1.listFiles(new FilenameFilter() {
		   public boolean accept(File dir,com.hs_vae.String name) {
			 //过滤规则pathname是文件夹或者是.java结尾的文件返回true
			 //在这里有一个转换动作:将dir和name封装为一个File对象
            return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
		   }
	   });*/
	   
	   /* 
	   //使用Lambda表达式优化匿名内部类(前提接口中只有一个抽象方法)
	   File[] f2=f1.listFiles((File dir,com.hs_vae.String name)->{
           return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
	   });*/
	   //还可以进一步优化
	   File[] f2=f1.listFiles((dir,name)->new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java"));
	   int i=0;
	for(File f3:f2) {           
		if(f3.isDirectory()) {         //先判断一下是否为文件夹
			getAllFile(f3);            //如果是文件夹的话再次递归遍历文件夹，递归自己调用自己
		}else{                        
	        	  System.out.println(f3);  //如果是文件夹则直接打印
	         }
		}
	}
   }
