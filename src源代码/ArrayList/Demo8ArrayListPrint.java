package com.hs_vae.ArrayList;
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
