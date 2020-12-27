package com.hs_vae.Interface;
/*
    接口就是多个类的公共规范.
    接口是一种引用数据类型,最重要的内容就是其中的:抽象方法
    接口格式:
       public interface 接口名称 {
              //接口内容
       }
    虽然换了换了关键字interface,但是编译生成的字节码文件仍然是 .java -->.class
    java 9接口就可以包含的内容有:
      1.常量
      2.抽象方法
      3.默认方法
      4.静态方法
      5.私有方法

    接口的使用步骤:
    1.接口不能直接使用,必须有一个"实现类"来"实现"该接口。
    格式：
      public class 实现类名称 impliments 接口名称{
            //....
      }
     2.接口的实现类必须覆盖重写(实现)接口中所有的抽象方法,去掉abstract关键字,加上方法体大括号
       注意:如果实现类并没有覆盖重写接口中所有的抽象方法,那么这个实现类必须是抽象类
     3.创建实现类的对象,进行使用
 */
public interface MyInterfaceAbstract {
    public abstract void abs();
}
