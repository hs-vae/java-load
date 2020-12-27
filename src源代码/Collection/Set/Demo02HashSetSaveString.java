package com.hs_vae.Collection.Set;
import java.util.HashSet;
public class Demo02HashSetSaveString {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = new String("重地");
        String s4 = new String("通话");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        //集合重写了toString方法,直接打印
        System.out.println(set);   //[重地, 通话, abc]
        //打印输出s1,s2,s3,s4四个哈希值
        System.out.println(s1.hashCode()); //96354
        System.out.println(s2.hashCode()); //96354
        System.out.println(s3.hashCode()); //1179395
        System.out.println(s4.hashCode()); //1179395
    }
}
