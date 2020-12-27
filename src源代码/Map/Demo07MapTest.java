package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    计算一个字符串每个字符出现的次数
 */
public class Demo07MapTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String next = scanner.next();
        //使用多态Map集合实现类对象
        Map<Character,Integer> map = new HashMap<>();
        //遍历字符串,获取每一个字符
        for (char key : next.toCharArray()) {
            if (map.containsKey(key)){
                //如果这个字符key存在
                Integer value = map.get(key);
                value++;
                map.put(key,value);
            }else {
                //如果这个字符key不存在
                map.put(key,1);
            }
        }
        //使用keySet方法遍历Map集合
        for (Character key : map.keySet()) {
            System.out.println(key+"="+map.get(key));
        }
    }
}
