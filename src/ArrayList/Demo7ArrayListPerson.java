package com.hs_vae.ArrayList;
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
