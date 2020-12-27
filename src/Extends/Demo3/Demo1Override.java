package com.hs_vae.Extends.Demo3;
//Date:2020.10.25
/*
　　　   方法覆盖重写的注意事项:

     　　1.必须保证父子类之间方法的名称相同,参数列表也相同.
     　　@Override:卸载方法前面,用来检测是不是有效的正确覆盖重写
     　　这个注释不写只要满足要求也是正确的,最好写因为可以提醒自己
    　　
    　　　2.子类方法的返回值必须小于等于父类方法的返回值范围
         扩展:java.lang.Object类是所有类的公共最高父类(祖宗类),String就是子类
　　　　　　
    　　　3.子类方法的权限必须大于等于父类方法的权限修饰符
         扩展: public > protected > (default) > private
         注意:　(default)不是关键字default,而是什么都不写,留空
 */
public class Demo1Override {
    public static void main(String[] args) {
        Zi zi=new Zi();
        zi.method();
    }
}
