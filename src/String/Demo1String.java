package com.hs_vae.String;
/*
    字符串比较的相关方法

    ==是进行对象的地址值比较,如果确实需要字符串的内容比较,可以使用两个方法

    public boolean equals(Object obj):参数可以是任何对象,只有参数是一个字符串并且内容相同的才会给ture,否则返回false
    备注：任何对象都能使用Object进行接收
 */
public class Demo1String {
    public static void main(String[] args) {
        byte[] bytes={97,98,99};
        String str1=new String(bytes);
        System.out.println("字符串是:"+str1);
        String str2=null;
        String str3="VaE";
        System.out.println(str2.equalsIgnoreCase(str3)); //忽视大小写
        System.out.println("vae".equals(str2)); //推荐常亮字符串写在前面
        System.out.println(str2.equals(str2));  //不推荐写法,因为当str2=null时会产生空指针异常
    }
}
