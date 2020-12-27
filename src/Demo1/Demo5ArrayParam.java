package com.hs_vae.Demo1;
public class Demo5ArrayParam {
    public static void main(String[] args) {
		int[] b= {1,2,3,4,5};
		System.out.println(b);
		System.out.println("---------------");
		array(b); //传递的是b的地址值
}
    public static void array(int[] a) {
    	System.out.println(a); //a的地址值
    	for(int i=0;i<a.length;i++) {
    		System.out.println(a[i]);
    	}
    }
}
