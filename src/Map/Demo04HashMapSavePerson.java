package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
      HashMap存储自定义类型的值
      Map集合保证key是唯一的:
        作为key的元素,必须重写hashCode和equals方法,以保证key唯一
 */
public class Demo04HashMapSavePerson {
    public static void main(String[] args) {
        show01();
        show02();
    }
    /*
         HashMap存储自定义类型键值
         当key为String类型,value为Person类型时
         key:String类型,由于String类型重写了hashCode和equals方法,可以保证key唯一
         value:Person类型,value可以重复
     */
    private static void show01() {
        //创建HashMap集合
        HashMap<String,Person> map = new HashMap<>();
        //往集合添加元素
        map.put("安徽",new Person("许嵩",34));
        map.put("山东",new Person("徐良",33));
        map.put("辽宁",new Person("汪苏泷",31));
        map.put("安徽",new Person("朱丹丹",30));
        //使用map中的keySet方法遍历
        Set<String> set = map.keySet();
        for (String key : set) {
            Person value = map.get(key);
            System.out.println(key+"="+value);
        }
    }
    /*
         HashMap存储自定义类型键值
         当key为Person类型,value为String类型时
         key:Person类型,Person类必须重写hashCode和equals方法,以保证key唯一
         value:String类型,value可以重复
     */
    private static void show02() {
        //创建HashMap集合
        HashMap<Person,String> map = new HashMap<>();
        //往集合添加元素
        map.put(new Person("许嵩",34),"安徽");
        map.put(new Person("徐良",33),"山东");
        map.put(new Person("汪苏泷",31),"辽宁");
        //Person类重写了hashCode和equasl方法,保证key唯一,那么这个value值"合肥"会覆盖"安徽"
        map.put(new Person("许嵩",34),"合肥");
        Set<Map.Entry<Person, String>> set = map.entrySet();
        for (Map.Entry<Person, String> entry : set) {
            Person key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }
}
