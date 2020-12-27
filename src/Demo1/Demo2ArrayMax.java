package com.hs_vae.Demo1;

public class Demo2ArrayMax {
	public static void main(String[] args) {
		int[] a= {20,50,100,6000,454,8000};
		int max=a[0];
		for(int i=1;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
		}
		System.out.println("最大值max为:"+max);
	}
}
