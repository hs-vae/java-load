package com.hs_vae.Demo1;
//Date:2020.9.28 
//Content:方法有参和无参，有返回值和无返回值,以及方法的调用.
//Note:返回值类型必须与方法类型保持一致
public class Method{
	public static void main(String[] args) {
    
	int sum=sum1(6,6);               //赋值调用
	System.out.println("两个数之和:"+sum);
	
	System.out.println(sum1(6,6));   //打印调用
	
	sum2(6,6);          	
	sum3();     //无参数时候必须采用单独调用         
	sum4();                     
	}
	 
	//有参数有返回值的方法1
	public static int sum1(int a,int b) {
		return a+b;
	}
	
    //有参数无返回值的方法2
	public static void sum2(int a,int b) {
		int sum=a+b;
		System.out.println("两个数之和为:"+sum);
	}
	
	//无参数有返回值的方法3
	public static int sum3() {
		int sum=0,a=6,b=6;
		sum=a+b;
		System.out.println("两个数之和为:"+sum);
		return sum;		
	}
	
	//无参数无返回值的方法4
	public static void sum4() {
		int a=6,b=6;
        int sum=a+b;
	   System.out.println("两个数之和为:"+sum);
	}

}
