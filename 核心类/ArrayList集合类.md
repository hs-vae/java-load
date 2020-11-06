<!-- toc -->

## 一、ArrayList集合类的简单概述和使用

```java
package Demo3;
//Date:2020.10.11
/*

 * 数组的长度不可以改变,而ArrayList集合长度可以改变 

 * ArrayList有一个尖括号<E>代表泛型

 * 创建对象格式: ArrayList<E> list =new ArrayList<>();

 * 一旦泛型<E>确定类型,比如String，那么该集合都是统一的String类型

 * 泛型只能是引用类型，不能使用基本类型
   */
   import java.util.ArrayList;
   public class Demo2ArrayList {
   public static void main(String[] args) {
   	ArrayList<String> list=new ArrayList<>();
   	

   	System.out.println(list);   //输出默认值:[]
   	
   	list.add("许嵩,周杰伦");      //加入元素使用add方法 
   	System.out.println(list); //此时集合长度为2
   	
   	list.add("汪苏泷");
   	list.add("单色凌");
   	System.out.println(list); //添加两个字符串后，加上前面两个长度变成了4

   }
   }
```

## 二、ArrayList集合类的常用方法

```java
package Demo3;
//Date:2020.10.11
/*

 * ArrayList类当中常用的方法:

 * public boolean add(E e):向集合当中添加元素,参数类型和泛型一样

 * public E get(int index):向集合当中获取元素,参数是索引编号,返回值就是对应位置的元素,是获取而不是拿,说明那个元素获取完以后还在

 * public E remove(int index):从集合当中删除元素,参数是索引编号,返回值就是被删掉的元素

 * public int size():获取集合的长度，返回值就是集合中包含的个数
   */
   import java.util.ArrayList;
   public class Demo3ArrayListMethod {
   public static void main(String[] args) {
   	ArrayList<String> list=new ArrayList<>();
   	list.add("许嵩");
   	list.add("周杰伦");
   	list.add("汪苏泷");
   	boolean success=list.add("单色凌");  //
   	System.out.println(success);        //输出的是true
   	System.out.println(list);           //输出:[许嵩, 周杰伦, 汪苏泷, 单色凌]


   	String name=list.get(2);            //获取索引值为2的元素，注意这里面name的数据类型必须和泛型保持一致,即String类型
   	System.out.println(name);           //打印 汪苏泷
   	
   	String removeName=list.remove(1);   //删除索引值为1的元素,即"周杰伦"
   	System.out.println(list);           //输出:[许嵩, 汪苏泷, 单色凌]
   	
   	int num=list.size();                //获取list集合的长度及集合所包含元素的个数
   	System.out.println("集合的长度及个数为:"+num);     //因为前面删除了一个元素,所以输出的应该是3

   }
}
```

## 三、ArrayList的遍历

```java
package Demo3;
//Date:2020.10.11
/*

 * ArrayList遍历
   */
   import java.util.ArrayList;
   public class Demo4ArrayListeach {
   public static void main(String[] args) {
   	ArrayList<String> list=new ArrayList<>();
   	list.add("许嵩");
   	list.add("汪苏泷");
   	list.add("单色凌");
   	

   	//遍历就会想到for循环
   	for(int i=0;i<list.size();i++) {               //集合的个数可以采用list.size()方法
   		System.out.println("集合为:"+list.get(i));  //获取集合的元素可以采用list.get(int index)方法
   	}

   }

}
```

## 四、ArrayList存储基本类型

```java
package Demo3;
//Date:2020.10.12
/*
 * 如果希望向ArrayList中存储基本类型，那么必须使用基本类型的包装类
 * 基本类型      包装类
 * byte         Byte
 * short        Short
 * int          Integer
 * float        Float
 * long         Long
 * char         Character
 * boolean      Boolean
   */
   import java.util.ArrayList;
   public class Demo5ArrayListBasic {
   public static void main(String[] args) {
   	ArrayList<Integer> listA=new ArrayList<>();
   	listA.add(5);
   	System.out.println(listA);
   	ArrayList<Float> listB=new ArrayList<>();
       listB.add(5.2F);
   	System.out.println(listB.get(0));
   	ArrayList<Character> listC=new ArrayList<>();
       listC.add('a');
       System.out.println(listC);		
   }

}
```

## 五、ArrayList练习

### 练习一:生成6个1到33之间的随机整数，添加到集合，并且遍历集合

```java
package Demo3;
//Date:2020.10.12
/*

*练习一:生成6个1到33之间的随机整数，添加到集合，并且遍历集合
*/
import java.util.Random;
import java.util.ArrayList;
public class Demo6ArrayListRandom {
   public static void main(String[] args) {
	Random a=new Random();
	

	ArrayList<Integer>  list=new ArrayList<>();
	for(int i=0;i<6;i++) {
		int[] num=new int[6];
	    num[i]=a.nextInt(33)+1;           //num可以生成1到33之间的随机整数
		list.add(num[i]);
	}
	for(int i=0;i<list.size();i++) {      //遍历集合
		System.out.println(list.get(i));			
	}

}
}
```

### 练习二:自定义4个人对象,添加到集合,并遍历

```java
package Demo3;
//Date:2020.10.11
public class Person {
	private String name;
	private int age;
	public Person() {
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
```

```java
 * package Demo3;
   import java.util.ArrayList;
   //Date:2020.10.12
   /*
    * 练习二:自定义4个人对象,添加到集合,并遍历
      */
      public class Demo7ArrayListPerson {
          public static void main(String[] args) {
      		ArrayList<Person> list=new ArrayList<>();
      		Person one=new Person("许嵩",20);
      		Person two=new Person("孙子涵",26);
      		Person three=new Person("单色凌",27);
      		Person four=new Person("颜小健",25);
              list.add(one);
              list.add(two);
              list.add(three);
              list.add(four);
              for(int i=0;i<list.size();i++) {     //集合遍历
              	Person a=list.get(i);            //获取list集合元素值赋值给a对象       
              	System.out.println("姓名是:"+a.getName()+",年龄:"+a.getAge());
              }
      	}
      }


```

### 练习三:打印集合的方法,使用{}括起来,使用#分隔每个元素

```java
 * package Demo3;
   //Date:2020.10.12
   /*

    * 练习三:打印集合的方法,使用{}括起来,使用#分隔每个元素

    * 格式:{元素#元素#元素#}
      */
      import java.util.ArrayList;
      public class Demo8ArrayListPrint {
      public static void main(String[] args) {
      	ArrayList<String> list=new ArrayList<>();
      	list.add("迪丽热巴");
      	list.add("古力娜扎");
      	list.add("马尔扎哈");
          System.out.println(list);	//[迪丽热巴, 古力娜扎, 古力娜扎]
        

          //调用
          printArrayList(list);  

      }
          

          //定义一个printArrayList方法
          public static void printArrayList(ArrayList<String> list) {      //集合传递的list是一个地址值
                  System.out.print("{");               //一行输出,不要换行
                  for(int i=0;i<list.size();i++) {
                  	String name=list.get(i);
                  	if(i==list.size()-1) {
                        System.out.print(name+"}");    //当输出元素个数-1时候，输出  "名字}"   
                  	}else {
                  		System.out.print(name+"#");  //"名字#"
                  	}
                  }
          }

   }


```

### 练习四:用一个大集合存入20个随机数字,然后筛选其中的偶数元素,放到小集合当中

```java
package Demo3;
import java.util.ArrayList;
import java.util.Random;
//Date:2020.10.12
/*

 * 练习四:用一个大集合存入20个随机数字,然后筛选其中的偶数元素,放到小集合当中
 * 要求使用自定义的方法来实现筛选
   */
   public class Demo9ArrayListReturn {
         public static void main(String[] args) {
       	 chooseArrayList(100,20);    //调用方法，100表示[1,100]区间,20表示筛选元素个数,即从区间中选20个随机数并且挑出偶数利用集合形式进行输出
         }
   		public static void chooseArrayList(int n1,int n2) {    //n1代表区间,n2代表筛选元素的个数
   		ArrayList<Integer> listA=new ArrayList<>();    //集合listA用于存储20个随机数字
   		ArrayList<Integer> listB=new ArrayList<>();    //集合listB用于存储筛选后的偶数元素
   		Random num=new Random();
   		for(int i=0;i<n2;i++) {
   			int a=num.nextInt(n1)+1;         //在[1,100]之间生成20个随机数并且存储到listA中
               listA.add(a);
   		}
   		System.out.println("20个随机数为:"+listA);           //查看有哪些20个随机数字
   		for(int i=0;i<listA.size();i++) {	
   			if(listA.get(i)%2==0) {          //判断当listA集合元素为偶数时候，将元素值获取并且赋值给b，最后将b的值在加到listB集合中       
    			    int b=listA.get(i);      
    			    listB.add(b);  
    			}
    		}
    		System.out.println("偶数的个数为:"+listB.size());
    		System.out.print("其中偶数为:"+listB);             //输出从20个随机数字挑选为偶数的集合
    }	
   }
```

