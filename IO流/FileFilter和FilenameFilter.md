<!-- toc -->

## FileFilter过滤器使用

```java
package Demo4.Filter;
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
 

```

创建个FileFilter的实现类,重写过滤方法accept

```java
package Demo4.Filter;
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

```

## FilenameFilter接口

```java
package Demo4.Filter;
/*
* FilenameFilter过滤器使用以及Lambda表达式优化匿名内部类(因为它只有一个accept方法)
*/
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
public class Demo2FilenameFilter {
	public static void main(String[] args) {
		File a=new File("//home//hs//eclipse-workspace//vae");
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
		   public boolean accept(File dir,String name) {
			 //过滤规则pathname是文件夹或者是.java结尾的文件返回true
			 //在这里有一个转换动作:将dir和name封装为一个File对象
            return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
		   }
	   });*/
	   
	   /* 
	   //使用Lambda表达式优化匿名内部类(前提接口中只有一个抽象方法)
	   File[] f2=f1.listFiles((File dir,String name)->{
           return new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java");
	   });*/
	   //还可以进一步优化
	   File[] f2=f1.listFiles((dir,name)->new File(dir,name).isDirectory()||name.toLowerCase().endsWith(".java"));
	   
	for(File f3:f2) {           
		if(f3.isDirectory()) {         //先判断一下是否为文件夹
			getAllFile(f3);            //如果是文件夹的话再次递归遍历文件夹，递归自己调用自己
		}else{                        
	        	  System.out.println(f3);  //如果是文件夹则直接打印
	         }
		}
	}
   }

```

再给出一个案例：

```java
package Demo4.Filter;
import java.io.File;
import java.io.FilenameFilter;
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
			public boolean accept(File dir,String name) {
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

```

