package com.hs_vae.ArrayList;
//Date:2020.10.11
/*
 * 数组的长度不可以改变,而ArrayList集合长度可以改变 
 * ArrayList有一个尖括号<E>代表泛型
 * 创建对象格式: com.hs_vae.ArrayList<E> list =new com.hs_vae.ArrayList<>();
 * 一旦泛型<E>确定类型,比如String，那么该集合都是统一的String类型
 * 泛型只能是引用类型，不能使用基本类型
 */
import java.util.ArrayList;
public class Demo2ArrayList {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		
		System.out.println(list);   //[]
		
		list.add("许嵩,周杰伦");      //加入元素使用add方法 
		System.out.println(list); //此时集合长度为2
		
		list.add("汪苏泷");
		list.add("单色凌");
		System.out.println(list); //添加两个字符串后，加上前面两个长度变成了4
	}
}
