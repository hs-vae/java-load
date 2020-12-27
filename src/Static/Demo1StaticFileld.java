package com.hs_vae.Static;
/*
      如果一个成员变量使用了static关键字,那么这个变量不再属于对象自己
     而是属于所在的类,多个对象共享同一份数据
 */
public class Demo1StaticFileld {
    public static void main(String[] args) {
        Student one=new Student("lz",20);
        one.room="观7-251";
        System.out.println("姓名是:"+one.getName()+",年龄是:"+one.getAge()+
                ",教室是:"+one.room+",学号是:"+one.getId());
        Student two=new Student("hs",20);
        System.out.println("姓名是:"+two.getName()+",年龄是:"+two.getAge()+
                ",教室是:"+two.room+",学号是:"+two.getId());
    }
}
