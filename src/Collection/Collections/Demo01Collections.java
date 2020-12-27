package com.hs_vae.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
      java.utils.Collections 集合工具类,用来对集合进行操作
      常用方法:
        - public static <T> boolean addAll(com.hs_vae.Collection<T> c,T...elements):往集合中添加一些元素
        - public static void shuffle(List<?> list) 打乱集合顺序,使用前提是List接口的实现类
 */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //使用工具类的addAll方法添加多个元素
        Collections.addAll(list,"许嵩","徐良","汪苏泷");
        System.out.println(list);    //[许嵩, 徐良, 汪苏泷]
        //使用工具类的shuffle方法打乱顺序
        Collections.shuffle(list);
        System.out.println(list);    //[徐良, 汪苏泷, 许嵩]
    }
}
