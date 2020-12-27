package com.hs_vae.String;

import java.util.Scanner;

/*
      练习:键盘输入一个字符串,并且统计其中各种字符出现的次数
      种类有:大写字母，小写字母，数字,其他
 */
public class Demo7String {
    public static void main(String[] args) {
        Scanner sr=new Scanner(System.in);
        System.out.print("请输入一个字符串:");
        String input=sr.next();
        int countUpper=0;
        int countLower=0;
        int countNumber=0;
        int countAnother=0;
        char[] arr=input.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch=arr[i];
            if(ch>='A'&&ch<='Z'){
              countUpper++;
            }else if(ch>='a'&&ch<='z'){
              countLower++;
            }else if(ch>='0'&&ch<='9'){
              countNumber++;
            }else{
              countAnother++;
            }
        }
        System.out.println("大写字母个数为:"+countUpper);
        System.out.println("小写字母个数为:"+countLower);
        System.out.println("数字的个数为:"+countNumber);
        System.out.println("其他的字符个数为:"+countAnother);
    }
}
