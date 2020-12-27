package com.hs_vae.String;
/*
    字符串截取的相关方法
      -public com.hs_vae.String substring(int index):截取从参数位置一致到字符串末尾,返回新字符串
      -public com.hs_vae.String substring(int begin,int end):截取从begin开始,一直到end结束中间的字符
      备注：[begin,end):包含左边,不包含右边
 */
public class Demo3String {
    public static void main(String[] args) {
        String str2="HelloWorld";
        System.out.println(str2.substring(5));     //从索引值5的位置开始截取
        System.out.println(str2.substring(5,8));   //这个截取有一个区间的[begin,end)注意是左闭右开,截取后不包含end
    }
}
