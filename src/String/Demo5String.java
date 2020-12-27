package com.hs_vae.String;
/*
      分割字符串的方法:
      public com.hs_vae.String[] split(com.hs_vae.String regex) 按照参数的规则,将字符串分成为若干部分
 */
public class Demo5String {
    public static void main(String[] args) {
        String str1="hs,vae";
        String[] arr=str1.split(",");  //将切割好的2份字符串放在一个字符串数组里面
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        //这里有个注意的地方,如果以"."进行切分,必须写成"\\.";
        String str2="Hello.Wrold";
        String[] arr2 = str2.split("\\.");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
