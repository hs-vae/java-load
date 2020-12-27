package com.hs_vae.Demo2;
//Date:2020.10.8
/*
 * 当方法的局部变量和类的成员变量重名时候，会优先使用局部变量的。
 * 要是需要使用本类当中的成员变量必须带上this
 * 格式为:this.成员变量名
 * 总结一句话来说:"通过谁调用的方法,谁就是this"
 */
public class Person {
	String name;   //成员变量
	
	public void showName() {
		System.out.println(name);
	}
	public void hello(String name) {
	    //第一个name是参数名字及局部变量,第二个名字是成员变量,如果不带上this则会混淆,this表示成员变量
		System.out.println("你好,"+name+"。我是:"+this.name);  
	}
}
