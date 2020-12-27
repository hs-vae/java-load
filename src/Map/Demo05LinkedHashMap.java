package com.hs_vae.Map;

import java.util.HashMap;
import java.util.LinkedHashMap;

/*
    Map接口的哈希表和链接列表实现，即存的顺序和取的顺序是一样的
    底层原理:
      哈希表+链表(记录元素的顺序)
 */
public class Demo05LinkedHashMap {
    public static void main(String[] args) {
        //不使用LinkedHashMap
        HashMap<String,Integer> map = new HashMap<>();
        map.put("许嵩",34);
        map.put("汪苏泷",33);
        map.put("徐良",31);
        map.put("许嵩",35);
        System.out.println(map);  //{许嵩=35, 徐良=31, 汪苏泷=33},存取顺序不一样
        //使用LInkedHashMap
        LinkedHashMap<String,Integer> linked = new LinkedHashMap<>();
        linked.put("许嵩",34);
        linked.put("徐良",33);
        linked.put("汪苏泷",31);
        linked.put("许嵩",35);
        System.out.println(linked);  //{许嵩=35, 徐良=33, 汪苏泷=31},存取顺序一样
    }
}
