<!-- toc -->

# Map集合概述

在现实生活中，有这样的一种集合：IP地址与主机名，身份证号与个人，系统用户名与系统用户对象等，这种一一对应的关系就叫做映射，在Java中，提供了专门的集合类用来存放这种关系的对象，即java.util.Map接口

Map接口定义了双列集合的规范，每次存储一对元素

Map<K，V>  K代表键的类型   V代表值的类型

Map集合的特点：

1. Map集合是一个双列集合，一个元素包含两个值(一个key，一个value)\
2. Map集合中的元素，key和value的数据类型可以相同也可以不同
3. Map集合中的元素，key是不允许重复的，value是可以重复的
4. Map集合中的元素，key与value是一一对应的

# Map集合常用子类

java.util.HashMap<k,v>集合  implements Map<k,v> 接口

HashMap集合的特点：

1. HashMap集合底层是哈希表，查询的速度非常快
2. HashMap集合是一个无序的集合，存储元素和取出元素的顺序有可能不一致

LinkedHashMap<k,v> 的特点

1. LinkedHashMap集合底层是哈希表+链表
2. LinkedHashMap集合是一个有序的集合，存储元素和取出元素的顺序是一致的

# Map接口中的常用方法

## put(K key, V value)

```java
public V put(K key, V value): 把指定的键与指定的值添加到Map集合中
返回值V:
  存储键值对时,如果key不重复,返回null
  如果key重复,会使用新的value替换map中重复的value,返回被替换的value值
```

案例

```java
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
```

## remove(Object key)

```java
public V remove(Object key): 把指定的键所对应的键值对元素在Map集合中删除,返回被删除元素的值value
返回值 V:
   如果key存在,v返回被删除的值
   如果key不存在,v返回null
```

案例

```java
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
```

## get(Object key)

```java
public V get(Object key) 根据指定的键,在Map集合中获取对应的值
返回值:
   key存在,返回对应的value值
   key不存在,返回null
```

案例

```java
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
```

# Map集合的遍历

## 通过键找值进行遍历

Map集合中的方法：

   Set<K> keySet() 返回此映射包含的键的Set视图

实现步骤：

1. 使用Map集合中的方法keySet(),将Map集合中所有的key取出来,存储到Set集合
2. 遍历Set集合,获取Map集合中每一个key
3. 通过Map集合中的方法get(key),通过key找到value

案例

```java
package Advanced.Map;

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
```

## 通过键值对Entry对象进行遍历

Map中存放的是两种对象，一种成为key(键)，一种称为value(值)，它们在Map中是一一对应关系，这一对对象又称作Map中的一个Entry项，Entry将键值对的对应关系封装成了对象，即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对(Entry)对象中获取对应的键与对应的值。

Map.Entry<K,V>：在Map接口中有一个内部接口Entry

作用：当Map集合一创建，那么就会在Map集合中创建一个Entry对象，用来记录键与值

Entry中两个方法

```java
- public K getKey():获取Entry对象中的键
- public V getValue():获取Entry对象中的值
```

Map集合中获取所有Entry对象的方法

```java
- public Set<Map.Entry<K,V>> entrySet():获取到Map集合中所有键值对对象的集合(Set集合)
```

遍历的实现步骤：

1. 使用Map集合中的方法entrySet()，把Map集合中多个Entry对象取出来，存储到一个Set集合中
2. 遍历Set集合，获取每一个Entry对象
3. 使用Entry对象中的方法getKey()和getValue()获取键与值

案例

```java
package Advanced.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
      Map集合遍历的第二种方式:使用Entry对象遍历
      Map集合中的方法:
         public Set<Map.Entry<K,V>> entrySet():获取到Map集合中所有键值对对象的集合(Set集合)
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
```

# HashMap存储自定义类型键值

Person 实体类

```java
package Advanced.Map;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
```

当key为String类型，value为Person类型时

由于String类型重写了hashCode和equals方法,可以保证key唯一

案例

```java
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
    //这时候由于上面key有一个是安徽，那么这个Person类型的value值会将new Person("许嵩",34)覆盖掉
    map.put("安徽",new Person("朱丹丹",30));
    //使用map中的keySet方法遍历
    Set<String> set = map.keySet();
    for (String key : set) {
        Person value = map.get(key);
        System.out.println(key+"="+value);
    }
}
```

当key为Person类型，value为String类型时

这时候Person必须重写hashCode和equals方法保证key是唯一的

案例

```java
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
```

# LinkedHashMap集合

它是HashMap集合的一个子类

能够保证成对的元素存放顺序是一样的

是有哈希表和链表组合的一个数据存储结构

案例

```java
package Advanced.Map;

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
```

# Hashtable 集合

Hashtable集合与HashMap集合一样都是Map接口的实现类

不同的是Hashtable集合是不允许存储空的键和值的

而HashMap集合是允许存储空的键和值的

案例

```java
package Advanced.Map;

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
```

# 练习：计算字符串每个字符出现的次数

案例实现

```java
package Advanced.Map;

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
                //如果这个字符key不存在,就添加到集合中,并设置value初始值为1
                map.put(key,1);
            }
        }
        //使用keySet方法遍历Map集合
        for (Character key : map.keySet()) {
            System.out.println(key+"="+map.get(key));
        }
    }
}
```



