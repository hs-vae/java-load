package com.hs_vae.String;
/*
      练习:定义一个方法,把数组{1,2,3}按照指定格式拼接成一个字符串，格式参考:[word1#word2#word3]
 */
public class Demo6String {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        printString(arr);
    }
    private static void printString(int[] arr) {
          String a="[";
        for (int i = 0; i < arr.length; i++) {
          a+="word"+arr[i]+"#";
          if(i== arr.length-1){
              a+="word"+arr[i]+"]";
              break;
          }
        }
        System.out.println(a);
    }
}

