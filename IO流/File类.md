<!-- toc -->

# File类的静态成员变量

```java
package Demo4;
import java.io.File;
public class Demo1File {
	public static void main(String[] args) {
		 String pathseparator=File.pathSeparator;
		 System.out.println(pathseparator);    //路径分隔符 windows:分号； linux:冒号:		 
		 String separator=File.separator;
		 System.out.println(separator);       //文件名称分隔符  windows:反斜杠\   linux:正斜杠:/		 
	}
}
```

# 绝对路径和相对路径

```java
package Demo4;
//Date:2020.10.14
/*
 * 绝对路径:是一个完整的路径，就linux而言从根目录开始,windows从盘符开始
 *      linux举例:
 *      //home//hs//eclipse-workspace//vae//src//Demo4IO//Demo2File
 *      windous举例：
 *      c:\\Users\\itcast
 * 相对路径:是一个简化的路径
 *       相对指的是相对于当前项目的根目录(//home//hs//eclipse-workspace//vae//src//Demo4IO)
 *       如果使用当前项目的根目录,路径可以简化写为:
 *       //home//hs//eclipse-workspace//vae//src//Demo4IO//123.txt-->123.txt
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
		File f1=new File("//hs//home//eclipse-workspace//vae//src//Demo4IO//123.txt");  //路径以文件结尾,绝对路径
		System.out.println(f1);
		File f2=new File("//hs//home//eclipse-workspace//vae//src//Demo4IO");           //路径以目录结尾，绝对路径
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

```

# File类获取功能的方法

```java
package Demo4;
import java.io.File;
//Date:2020.10.14
/*
 * File类获取功能的方法
 *      public String getAbsolutePath():返回此File的绝对路径字符串
 *      public String getPath():将此File转换为路径名字符串
 *      public String getName():返回由此File表示的文件或目录的名称
 *      public long length():返回由此File表示的文件的长度,以字节为单位,文件夹长度是为0,没有大小概念
 */
public class Demo3FileObtain {
      public static void main(String[] args) {
    	  show1();
    	  show2();
    	  show3();
    	  show4();
	}
      public static void show1() {
    	 File f1=new File("123.txt");
		 System.out.println(f1.getAbsolutePath()); 
      }
      public static void show2() {
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
    	  File f2=new File("123.txt");
    	  System.out.println(f1.getPath());
    	  System.out.println(f2.getPath());
    	  System.out.println(f1.toString());
      }
      public static void show3() {          
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
          System.out.println(f1.getName());          
      }
      public static void show4() {
    	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
    	  File f2=new File("//home//hs//eclipse-workspace//vae");
          System.out.println(f1.length());
          System.out.println(f2.length());
      }
}

```

# File类判断功能的方法

```java
package Demo4;
import java.io.File;
//Date:2020.10.14
/*
 * File类判断功能的方法
 *        public boolean exists():此File表示的文件或目录是否实际存在
 *        public boolean isDirectory():此File表示的是否为目录
 *        public boolean isFile():此File表示的是否为文件
 * 注意:
 * 3个方法都是为布尔类型,存在输出:true,不存在输出:false
 * isDirectory方法和isFile方法首先判断一下这个文件或文件夹是否存在，在判断是否为目录或者文件
 */
public class Demo4FileJudgment {
	public static void main(String[] args) {
		show1();
		show2();
	}
	public static void show1() {
  	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");  
  		  System.out.println(f1.exists());    
	}
	public static void show2() {
  	  File f1=new File("//home//hs//eclipse-workspace//vae//123.txt");
	  File f2=new File("//home//hs//eclipse-workspace//vae");
	  if(f1.exists()) {       //先判断这个文件或文件夹是否存在
		  System.out.println("f1是否为文件:"+f1.isFile());
		  System.out.println("f1是否为目录:"+f1.isDirectory());
	  }
	  if(f2.exists()) {
		  System.out.println("f2是否为文件:"+f2.isFile());
		  System.out.println("f2是否为目录:"+f2.isDirectory());
	  }
	}
}

```

# File创建删除功能的方法

```java
package Demo4;
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
		showdelete();
		showCreateNewFile();
		showmkdirs();
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

```

# File类遍历(文件夹)目录功能

```java
package Demo4;
import java.io.File;
//Date:2020.10.14
/*
 *    File类遍历(文件夹)目录功能
 *     -public String[] list():返回一个String数组,表示该File目录中的所有子文件或目录。隐藏的文件夹也可以输出
 *     -public File[] listFiles():返回一个File数组,表示该File目录中的所有的子文件或目录
 * 注意:
 *     list方法和listFiles方法遍历的是构造方法中给出的目录
 *     如果构造方法中给出的目录的路径不存在,会抛出空指针异常
 *     如果构造方法中给出的路径不是一个目录,也会抛出空指针异常
 */
public class Demo5FileTraverse {
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
```



