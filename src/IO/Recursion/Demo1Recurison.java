package com.hs_vae.IO.Recursion;
//Date:2020.10.15
/*
 * 递归:方法自己调用自己
 *    -注意：
 *    递归一定要有限定条件，保证递归能够停止下来,否则会发生栈内存溢出
 *    有限定条件下,递归次数不能太多
 *    构造方法,禁止递归
 *    -递归使用前提:
 *    当调用方法的时候，方法的主体不变，每次调用方法的参数不同，可以使用递归
 */
public class Demo1Recurison {
	public static void main(String[] args) {
		//a();
		b(1);
	}
	//要加限定条件
    public static void a() {
    	System.out.println("调用了a方法");
    	a();
    }

    //即使有限定条件但是次数过大还是会发生栈内存溢出，报错
    public static void b(int i) {
    	System.out.println(i);
    	if(i==200000) {
    		return; //结束方法
    	}
    	b(++i);
    }
       
}
