package com.hs_vae.String;
/*
     String相关的转换方法
       -public char[] toCharArray():将当前字符串拆分为字符数组作为返回值
       -public byte[] getBytes():获得当前字符串底层的字节数组
       -public com.hs_vae.String replace(CharSequence oldString,CharSequence newString),
       将所有出现的老字符串替换为新的字符串,返回替换之后的结果新字符串

 */
public class Demo4String {
    public static void main(String[] args) {
        char[] array="HelloWorld".toCharArray(); //可以将字符串转换为一个个字符
        System.out.println(array[0]);
        System.out.println(array.length);

        byte[] bytes="HelloWorld".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        String lang1="闯红灯,你想死吗?";
        String lang2 = lang1.replace("死", "*"); //repalce可以进行替换字符串
        System.out.println(lang2);  //闯红灯,你想*吗?
    }
}
