package com.hs_vae.IO.TryCatch;
import java.io.FileWriter;
import java.io.IOException;
/*
      在jdk1.7之前使用try catch finally处理流中的异常
      格式:
          try{
             可能会产出异常的代码
          }catch(异常类变量 变量名){
          异常的处理逻辑
          }finally{
          一定会指定的代码
          释放资源
          }
 */
public class Demo1TryCatch {
    public static void main(String[] args) {
        //提高变量fw的作用域,让finally可以使用
        //变量在定义的时候,可以没有值,但是使用的时候必须有值,给fw赋个空值null
        //fw=new FileWriter("hello.txt",true);执行失败,fw没有值,fw.close()会报错
        FileWriter fw=null;
        try{
            //可能会产出异常的代码
            fw=new FileWriter("hello.txt",true);                         
            for (int i = 0; i < 10; i++) {
                fw.write("Hello World"+"\n");
            }
        }catch (IOException e){
            //异常的处理逻辑
            System.out.println(e);
        }finally {
            //一定会执行的代码
            //创建对象失败了,fw的默认值就是null,null是不能调用方法的,会抛出NullPointerException，需要增加一个判断,不是null在把资源释放
            if (fw!=null){
             try{
                 //fw.close方法声明抛出了IOException异常对象,所以我们就得处理这个异常对象,继续trycatch
                 fw.close();
             }catch (IOException e){
                 System.out.println(e);
             }
          }
        }
    }
}
