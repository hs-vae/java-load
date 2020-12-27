package com.hs_vae.ArrayList;
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
