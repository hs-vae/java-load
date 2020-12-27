package com.hs_vae.ArrayList;
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
