package com.hs_vae.Demo2;
/*
 一个标准的构造方法必须满足四个要素:
 1.成员变量必须有private修饰
 2.包含有参数的构造方法
 3.包含无参数的构造方法
 4.包含getter和setter方法
 */
public class Student {
     private String name;
     private int age;
     
    
	public Student() {
	}
	
	public Student(String name, int age) {
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
