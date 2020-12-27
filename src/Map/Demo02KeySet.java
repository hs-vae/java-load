package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
     Map集合的第一种遍历方式:通过键找值的方式
     Map集合中的方法:
        Set<K> keySet() 返回此映射包含的键的Set视图
     实现步骤:
       1.使用Map集合中的方法keySet(),将Map集合中所有的key取出来,存储到Set集合
       2.遍历Set集合,获取Map集合中每一个key
       3.通过Map集合中的方法get(key),通过key找到value
 */
public class Demo02KeySet {
    public static void main(String[] args) {
        //使用多态创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("许嵩",34);
        map.put("徐良",33);
        //1.使用Map集合中的方法keySet(),将Map集合中所有的key取出来,存储到Set集合
        Set<String> set = map.keySet();
        //2.遍历Set集合,获取Map集合中每一个key
        for (String key : set) {
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer v = map.get(key);
            System.out.println(v);
        }
    }
}
