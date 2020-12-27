package com.hs_vae.IO.Properties;
import java.util.Properties;
import java.util.Set;
//Date:2020.10.17
/*
        java.util.Properties集合 extends Hashtable<k,v> implements com.hs_vae.Map<k,v>
        Properties类表示了一个持久的属性集.Properties可保存在流中或从流中加载。
        Properties集合是一个唯一和IO流相结合的集合
             可以使用方法store把集合中的临时数据持久化写入硬盘中存储
             可以使用方法load把硬盘保存的文件(键值对),读取到集合中使用
        属性列表中每个键及其对应值都是一个String字符串
             Properties集合是一个双列集合,key和value默认都是字符串
 */
public class Demo1Properties {
    public static void main(String[] args) {
        show1();
    }
    /*
           使用Properties集合存储数据,遍历取出Properties集合中的数据
           Properties集合是一个双列集合,key和value默认都是字符串
           Properties集合有一些操作字符串的特有方法
               Object setProperty(com.hs_vae.String key,com.hs_vae.String value)调用Hashtable的方法put
               com.hs_vae.String getProperty(com.hs_vae.String key)通过key找到value值,此方法相当于Map集合中的get(key)方法
               Set<com.hs_vae.String> stringPropertyNames()返回此属性列表中的键集,其中该键及其对应值是字符串,此方法相当于Map集合中的keySet方法
     */
    private static void show1() {
        Properties prop=new Properties();
        prop.setProperty("许嵩","有何不可");
        prop.setProperty("周杰伦","一路向北");
        prop.setProperty("汪苏泷","万有引力");

        //使用stringPropertyNames把Properties集合中的键取出,存储到一个set集合中
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {     //使用foreach遍历
            String value = prop.getProperty(key);   //通过key找到value的值
            System.out.println(key+":"+value);
        }

    }

}
