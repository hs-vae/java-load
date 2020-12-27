package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Map;

public class Demo01Map {
    public static void main(String[] args) {
        //show01();
        //show02();
        show03();
    }

    /*
         public V put(K key, V value): 把指定的键与指定的值添加到Map集合中
         返回值V:
           存储键值对时,如果key不重复,返回null
           如果key重复,会使用新的value替换map中重复的value,返回被替换的value值

     */
    private static void show01() {
        //使用多态创建Map集合对象
        Map<String,String> map = new HashMap<>();
        String v1 = map.put("hs", "vae");
        System.out.println(v1);   //null
        System.out.println(map);  //{hs=vae}
        String v2 = map.put("hs", "许嵩");
        System.out.println(v2);   //返回被替换的value值:vae
        System.out.println(map);  //{hs=许嵩}
    }
    /*
         public V remove(Object key): 把指定的键所对应的键值对元素在Map集合中删除,返回被删除元素的值value
         返回值 V:
            如果key存在,v返回被删除的值
            如果key不存在,v返回null
     */
    private static void show02() {
        //使用多态创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("许嵩",34);
        map.put("徐良",33);
        System.out.println(map); //{许嵩=34, 徐良=33}
        //使用remove方法
        //key存在
        Integer v1 = map.remove("许嵩");  //最好写int的包装类Integer,因为当key不存在可以防止空指针异常
        System.out.println(v1);  //34
        System.out.println(map); //{徐良=33}
        //key不存在
        Integer v2 = map.remove("许嵩");
        System.out.println(v2);   //null
        System.out.println(map);  //{徐良=33}
    }
    /*
        public V get(Object key) 根据指定的键,在Map集合中获取对应的值
        返回值:
           key存在,返回对应的value值
           key不存在,返回null
     */
    private static void show03() {
        //使用多态创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("许嵩",34);
        map.put("徐良",33);
        //当key存在时
        Integer v1 = map.get("许嵩");
        System.out.println(v1);   //34
        //当key不存在时
        Integer v2 = map.get("汪苏泷");
        System.out.println(v2);   //null
    }

}
