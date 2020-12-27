package com.hs_vae.ArrayList;
import java.util.ArrayList;
import java.util.Random;
//Date:2020.10.12
/*
 * 练习四:用一个大集合存入20个随机数字,然后筛选其中的偶数元素,放到小集合当中
 * 要求使用自定义的方法来实现筛选
 */
public class Demo9ArrayListReturn {
          public static void main(String[] args) {
        	 chooseArrayList(100,20);    //调用方法，100表示[1,100]区间,20表示筛选元素个数,即从区间中选20个随机数并且挑出偶数利用集合形式进行输出
          }
			public static void chooseArrayList(int n1,int n2) {    //n1代表区间,n2代表筛选元素的个数
			ArrayList<Integer> listA=new ArrayList<>();    //集合listA用于存储20个随机数字
			ArrayList<Integer> listB=new ArrayList<>();    //集合listB用于存储筛选后的偶数元素
			Random num=new Random();
			for(int i=0;i<n2;i++) {
				int a=num.nextInt(n1)+1;         //在[1,100]之间生成20个随机数并且存储到listA中
                listA.add(a);
			}
			System.out.println("20个随机数为:"+listA);           //查看有哪些20个随机数字
			for(int i=0;i<listA.size();i++) {	
				if(listA.get(i)%2==0) {          //判断当listA集合元素为偶数时候，将元素值获取并且赋值给b，最后将b的值在加到listB集合中       
				    int b=listA.get(i);      
				    listB.add(b);  
				}
			}
			System.out.println("偶数的个数为:"+listB.size());
			System.out.print("其中偶数为:"+listB);             //输出从20个随机数字挑选为偶数的集合
          }	
}
