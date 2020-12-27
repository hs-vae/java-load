package com.hs_vae.Demo1;

public class grade {
	public static void main(String[] args) {
		int score=50;
		if(score<0||score>100) {
			System.out.println("输入错误");
		}else if(score>=90) {
			System.out.println("成绩优秀");
		}else if(score>=60&&score<90) {
			System.out.println("成绩及格");
		}else {
			System.out.println("成绩不及格");
		}
	}
}
