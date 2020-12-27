package com.hs_vae.Map;

import java.util.HashMap;
import java.util.Hashtable;

/*
    HashMap集合(之前学的所有集合):可以存储null值,null键
    Hashtable集合,不能存储null值,null键
 */
public class Demo06Hashtable {
    public static void main(String[] args) {
        //创建一个HashMap集合
        HashMap<String,String> map = new HashMap<>();
        map.put(null,"vae");
        map.put("许嵩",null);
        map.put(null,null);
        System.out.println(map);  //{null=null, 许嵩=null}
        //创建一个Hashtable集合
        Hashtable<String,String> table = new Hashtable<>();
        table.put(null,"vae");
        table.put("vae",null);
        table.put(null,null);
        System.out.println(table);  //会出现空指针异常:NullPointerException
    }
}
