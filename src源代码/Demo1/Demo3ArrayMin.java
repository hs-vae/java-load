package com.hs_vae.Demo1;

public class Demo3ArrayMin {
	public static void main(String[] args) {
		int[] a=new int[]{10,20,30,50,60};
	    int min=a[0];
	    for(int i=1;i<a.length;i++) {
	    	if(a[i]<min) {
	    		min=a[i];
	    	}
	    }
		System.out.println("最小值为:"+min);
	}
}
