package com.hs_vae.Demo1;

public class Demo6ArrayReturn {
     public static void main(String[] args) {
	   int[] a=array(5,6);
	   System.out.println("a,b的和与乘积为：");
	   for(int i=0;i<a.length;i++) {
		   System.out.println(a[i]);
	   }
}
     public static   int[]   array(int a,int b) {
    	 int sum=a+b;
    	 int ave=(a+b)/2;
    	 int[] c= {sum,ave};
    	 return c;
}
}
