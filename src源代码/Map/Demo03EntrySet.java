package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
      Map集合遍历的第二种方式:使用Entry对象遍历
      Map集合中的方法:
         public Set<com.hs_vae.Map.Entry<K,V>> entrySet():获取到Map集合中所有键值对对象的集合(Set集合)
      实现步骤:
        1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        2.遍历Set集合,获取每一个Entry对象
        3.使用Entry对象中的方法getKey()和getValue()获取键与值
 */
public class Demo03EntrySet {
    public static void main(String[] args) {
        //使用多态创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("许嵩",34);
        map.put("徐良",33);
        //1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        //2.遍历Set集合,获取每一个Entry对象
        for (Map.Entry<String, Integer> entry : set) {
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
