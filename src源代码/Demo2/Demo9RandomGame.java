package com.hs_vae.Demo2;
import java.util.Scanner;
import java.util.Random;
//Date:2020.10.11
/*猜数字小游戏,在[1,100]随机生成一个数字n，然后键盘输入一个数字,直到两个数字相等,及猜对,游戏结束.
 * 首先随机生成一个数字randomNum，键盘输入一个数字guessNum
 * 分为3种情况:
 * randomNum>guessNum:太小了,请重试
 * randomNum<guessNum:太大了,请重试
 * randomNum=guessNum:猜中,游戏结束
 */
public class Demo9RandomGame {
	public static void main(String[] args) {
		Random a=new Random();
		int randomNum=a.nextInt(100)+1;
		while(true) {   //不明确循环次数时候用while
			System.out.println("请输入一个数:");
			Scanner b=new Scanner(System.in);
			int guessNum=b.nextInt();
			if(randomNum>guessNum) {
				System.out.println("太小了，重新输入:");
			}else if(randomNum<guessNum) {
				System.out.println("太大了,重新输入:");
			}else {
				System.out.println("恭喜你,猜对了!");
			}
		}
	}
}
