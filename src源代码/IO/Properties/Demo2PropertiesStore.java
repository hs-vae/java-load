package com.hs_vae.IO.Properties;
//Date:2020.10.17
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
     可以使用Properties集合中的方法store,把集合中的临时数据,持久化写入到硬盘中存储
     void store(OutputStream out,com.hs_vae.String comments)
     void store(Writer writer,com.hs_vae.String comments)
     参数：
         OutputStream out:字节输出流,但是注意不能写入中文
         Writer writer:字符输出流,可以写中文
         com.hs_vae.String comments:注释,用来解释说明保存的文件是做什么用的
                  不能使用中文,会产生乱码,默认是Unicode编码
                  一般使用""空字符串
      使用步骤:
          1.创建Properties集合对象,添加数据
          2.创建字节输出流/字符输出流对象,构造方法中绑定要输出的目的地
          3.使用Properties集合中的方法store
 */
public class Demo2PropertiesStore {
    public static void main(String[] args) throws IOException {
        show2();
    }
    private static void show2() throws IOException {
        FileWriter fw=new FileWriter("我是歌手.txt");
        Properties prop=new Properties();
        prop.setProperty("许嵩","有何不可");
        prop.setProperty("汪苏泷","万有引力");
        prop.setProperty("周杰伦","一路向北");
        prop.store(fw,"Singer");
        //prop.store(new FileOutputStream("singer"),"Singer");  //字节输出流识别不了中文,会产生乱码的
        fw.close();
    }
}
