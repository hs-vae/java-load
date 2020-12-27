package com.hs_vae.IO.TryCatch;

import java.io.FileWriter;
import java.io.IOException;
/*
      上面一个异常太麻烦了JDK7的新特性
      在try后边可以增加一个(),在括号里面定义流对象
      那么这个流对象的作用域就在try中有效
      try的代码执行完毕,会自动把流对象释放,不用写finally
      格式可以写成这样:
      try(定义流对象){
         可能会产生异常的代码
      }catch(异常变量类型 变量名){
          异常的处理逻辑
      }
 */
public class Demo2TryCatch {
    public static void main(String[] args) {
        try(FileWriter fw=new FileWriter("hello.txt",true);){
            for (int i = 0; i < 10; i++) {
                fw.write("你好"+"\n");
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
