package com.hs_vae.String;
/*
     String获取相关的常用方法
     public int length获取字符串当前的字符个数,及字符串长度
     public com.hs_vae.String concat(com.hs_vae.String str)将当前字符串和参数字符串连接为返回值的字符串
     public char charArt(int index)获取指定索引位置的单个字符
     public int indexOf(com.hs_vae.String str)查找参数字符串在本字符串当中首次出现的位置，如果没有返回-1值
 */
public class Demo2String {
    public static void main(String[] args) {
        int length="dasdasdasdasdasdas".length();
        System.out.println(length);
        String str1="hs";
        String str2="-vae";
        System.out.println(str1.concat(str2)); //hs-vae
        char ch="hs-vae".charAt(1);
        System.out.println(ch);
        System.out.println("HelloWorld".indexOf("ll"));
    }
}
