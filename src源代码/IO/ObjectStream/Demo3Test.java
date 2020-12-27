package com.hs_vae.IO.ObjectStream;
//Date:2020.10.18
/*
      练习:序列化集合
          当我们想在文件中保存多个对象的时候
          可以把多个对象存储到一个集合中,对集合进行序列化和反序列化
 */
import java.io.*;
import java.util.ArrayList;
public class Demo3Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.定义一个存储Person对象的ArrayList集合
        ArrayList<Person> list=new ArrayList<>();
        //2.往ArrayList集合中存储Person对象
        list.add(new Person("许嵩",34));
        list.add(new Person("汪苏泷",30));
        list.add(new Person("周杰伦",45));
        //3.创建一个序列化流ObjectOuputStream对象
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("歌手.txt"));
        //4.使用ObjectOutputStream中的writeObject,对集合进行序列化
        oos.writeObject(list);
        //5.创建一个反序列化ObjectInputStream对象
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("歌手.txt"));
        //6.使用ObjectInputStream对象中的方法readObject读取文件中保存的集合
         Object o=ois.readObject();
         //7.把Object类型的集合转换为ArrayList类型
        ArrayList<Person> list2=(ArrayList<Person>)o;
        //8.遍历ArrayList集合
        for (Person p : list2) {
            System.out.println(p);
        }
        //释放资源
        ois.close();
        oos.close();
    }
}
