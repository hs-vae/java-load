package com.hs_vae.ArrayList;
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
