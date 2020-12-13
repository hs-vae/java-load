<!-- toc -->

Set接口和List接口一样

都继承了Collection接口

与Collection接口中的方法基本一致

与List接口不同的是，Set接口中元素是无序的

而且都会以某种规则保证存入的元素不出现重复

# HashSet集合介绍与特点

Hashset 是Set 接口的一个实现类，

存储的元素不可重复并且没有顺序(存取顺序不一致)

底层的实现其实是一个HashMap

HashSet是根据对象的哈希值来确定元素在集合的存储位置

保证元素唯一的方式依赖于  hasCode与equals 方法

实现

```java
package Advanced.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
      java.util.Set接口 extends Collection接口
      Set接口的特点:
         1.不允许存储重复的元素
         2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历
      java.util.HashSet集合  implements Set接口
      HashSet特点:
         1.不允许存储重复的元素
         2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历,只能使用迭代器或增强for循环
         3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
         4.底层是一个哈希表结构,查询的速度非常快
 */
public class Demo01Set {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        //使用add方法添加元素到集合
        set.add("许嵩");
        set.add("徐良");
        set.add("许嵩");
        set.add("徐良");
        //使用迭代器遍历set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
//        //增强for循环遍历set集合
//        for (String s : set) {
//            System.out.println(s);
//        }
    }
}

//输出结果(重复的值出输出一次)
许嵩
徐良
```

# 哈希值

哈希值是一个十进制的整数

由系统随机给出(就是对象的地址值，是一个逻辑地址，模拟出来得到的地址，不是数据实际存储的物理地址)

在Object超类中有一个方法 

```java
int hashCode()
```

可以获取对象的哈希值

建立一个实体类Singer

覆盖重写hashCode() 方法

```java
package Advanced.hashCode;

public class Singer extends Object{
    @Override
    public int hashCode() {
        return 1;
    }
}

```

测试类

```java
package Advanced.hashCode;

public class Demo01HashCode {
    public static void main(String[] args) {
        Singer singer1=new Singer();
        int i1 = singer1.hashCode();
        System.out.println(i1);     //哈希值:1
        Singer singer2 = new Singer();
        int i2 = singer2.hashCode();
        System.out.println(i2);     //哈希值:1

        /*
             String类的哈希值
             String类重写了Object类的hashCode方法
         */
        String s1=new String("许嵩");
        String s2=new String("汪苏泷");
        System.out.println(s1.hashCode());  //哈希值:1132721
        System.out.println(s2.hashCode());  //哈希值:27737586
        //有两个特殊的字符串哈希值一样
        System.out.println("重地".hashCode()); //哈希值:1179395
        System.out.println("通话".hashCode()); //哈希值:1179395
    }
}
```

# HashSet集合存储数据的结构

HashSet集合存储数据的结构其实就是哈希表

java8之前 哈希表 = 数组 + 链表

之后 哈希表 = 数组 + 红黑树

![](https://picture.hs-vae.com/HashSet存储数据的结构.png)

# HashSet集合存储自定义类型元素

想要使Set集合保证元素唯一

存储的元素(String,Integer,Singer...)必须重写hashCode方法和equals方法

现在要求Singer歌手同名同年龄的人，视为同一个人，只能存储一次

如果不覆盖重写会存储两次

实体类Singer

```java
package Advanced.Set;

import java.util.Objects;

public class Singer extends Object{
    private String name;
    private int age;

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return age == singer.age &&
                Objects.equals(name, singer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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
}
```

测试类

```java
package Advanced.Set;

import java.util.HashSet;

/*
      HashSet存储自定义类型元素
      想要使Set集合保证元素唯一
      存储的元素(String,Integer,Singer...)必须重写hashCode方法和equals方法
      现在要求Singer歌手同名同年龄的人，视为同一个人，只能存储一次
      如果不覆盖重写会存储两次
 */
public class Demo03HashSetSaveSinger {
    public static void main(String[] args) {
        //创建HashSet集合存储Singer
        HashSet<Singer> set = new HashSet<>();
        Singer s1 = new Singer("许嵩",34);
        Singer s2 = new Singer("汪苏泷",31);
        Singer s3 = new Singer("汪苏泷",31);
        //Singer类覆盖重写hashCode和equals方法后
        System.out.println(s2.hashCode());  //哈希值:859866158
        System.out.println(s3.hashCode());  //哈希值:859866158
        set.add(s1);
        set.add(s2);
        set.add(s3);
        System.out.println(set); //[Singer{name='许嵩', age=34}, Singer{name='汪苏泷', age=31}]
    }
}
```

# Set集合存储不重复元素的原理

前提：存储的元素必须重写hashCode方法和equals方法

测试类

```java
package Advanced.Set;
import java.util.HashSet;
public class Demo02HashSetSaveString {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        String s1 = new String("abc");
        String s2 = new String("abc");
        String s3 = new String("重地");
        String s4 = new String("通话");
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        //集合重写了toString方法,直接打印
        System.out.println(set);   //[重地, 通话, abc]
        //打印输出s1,s2,s3,s4四个哈希值
        System.out.println(s1.hashCode()); //96354
        System.out.println(s2.hashCode()); //96354
        System.out.println(s3.hashCode()); //1179395
        System.out.println(s4.hashCode()); //1179395
    }
}
```

Set集合在调用add方法的时候，add方法会调用 hashCode方法和 equals方法，判断元素是否重复

执行：

```java
set.add(s1);
```

add 方法会调用hashCode方法，计算字符串"abc"的哈希值，哈希值为96354

在集合中找有没有96354这个哈希值的元素

发现没有

那么就会把 s1 存储到 set集合中

执行：

```java
set.add(s2);
```

add 方法会调用hashCode方法，计算字符串"abc"的哈希值，哈希值是96354

在集合中找有没有96354这个哈希值的元素

发现有，那么就会产生哈希冲突

接下来 s2 会调用equals方法与哈希值相同的元素进行比较 s2.equals(s1)，发现元素也一样，返回true

两个元素的哈希值相同而且equals方法返回true，认定两个元素相同

那么就不会把s2存储到 set 集合中

执行：

```java
set.add(s3);
```

add 方法会调用hashCode方法，计算字符串"重地"的哈希值，哈希值为1179395

在集合中找有没有1179395这个哈希值的元素

发现没有

那么就会把 s3 存储到 set集合中

执行：

```java
set.add(s4);
```

add 方法会调用hashCode方法，计算字符串"通话"的哈希值，哈希值是1179395

在集合中找有没有1179395这个哈希值的元素

发现有，那么就会产生哈希冲突

接下来 s4 会调用equals方法与哈希值相同的元素进行比较 s4.equals(s3)，发现元素不一样，返回false

两个元素的哈希值相同，但是equals方法返回false，认定两个元素不相同

那么就会把s4存储到 set 集合中

执行完毕后

存储地址图如下：

![](https://picture.hs-vae.com/Set存储元素原理.png)

## 

# LinkedHashSet 集合

LinkedHashSet 集合继承了HashSet集合

该集合的特点：

底层是一个哈希表(数组+链表/红黑树)+链表

多了一条链表，该链表用来记录元素的存储顺序

保证元素有序

但是仍然不允许存储重复元素

测试如下

```java
package Advanced.Collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("许嵩");
        set.add("徐良");
        set.add("徐良");
        set.add("汪苏泷");
        System.out.println(set); //[徐良, 许嵩, 汪苏泷],这是无序的,并且去重
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("许嵩");
        linked.add("许嵩");
        linked.add("徐良");
        linked.add("汪苏泷");
        System.out.println(linked); //[许嵩, 徐良, 汪苏泷],这是无序的，并且去重
    }
}

```

# 可变参数

使用前提：当方法的参数列表数据类型确定,但是参数的个数不确定

使用格式：定义方法时使用

```java
修饰符 返回值类型 方法名 (数据类型...变量名){
      方法体
}
```

可变参数的原理：

底层就是一个数组,根据传递参数个数不同,会创建不同长度的数组,来存储这些数

传递的参数个数,可以是0个,1,.....n个

可变参数的注意事项：

1. 一个方法的参数列表,只能有一个
2. 如果方法的参数有多个,那么可变参数必须写在参数列表的末尾

测试如下

```java
package Advanced.Collection.VarArgs;
/*
     使用前提:当方法的参数列表数据类型确定,但是参数的个数不确定
     使用格式:定义方法时使用
        修饰符 返回值类型 方法名 (数据类型...变量名){}
     可变参数的原理:
       底层就是一个数组,根据传递参数个数不同,会创建不同长度的数组,来存储这些数
       传递的参数个数,可以是0个,1,.....n个
 */
public class Demo01VarArgs {
    public static void main(String[] args) {
        int sum = add(1, 2, 3);
        System.out.println("数组总和:"+sum);
    }
    public static int add(int...arr){
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println("arr数组长度:"+arr.length);
        return sum;
    }
    /*
         可变参数的注意事项
           1.一个方法的参数列表,只能有一个
           2.如果方法的参数有多个,那么可变参数必须写在参数列表的末尾
     */
    /*public static void method(int...arr,int...brr){

    }*/
    public static void method(String a,double b,int...arr){

    }
    //可变参数的特殊写法,可以接收任意类型的数据,而且还能接收任意个数的数据
    public static void methodObject(Object...obj){

    }
}
```

