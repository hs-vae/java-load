java.utils.Collections是集合工具类

用来对集合进行操作

部分方法如下

```java
- public static <T> boolean addAll(Collection<T> c,T...elements):往集合中添加一些元素
- public static void shuffle(List<?> list) 打乱集合顺序,使用前提是List接口的实现类
- public static <T> void sort(List<T> list):将集合中元素按照默认规则(升序)排序
- public static <T> void sort(List<T> list,Comparator<? super T>),将集合按照指定规则排序
```

案例

```java
package Advanced.Collection.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
      java.utils.Collections 集合工具类,用来对集合进行操作
      常用方法:
        - public static <T> boolean addAll(Collection<T> c,T...elements):往集合中添加一些元素
        - public static void shuffle(List<?> list) 打乱集合顺序,使用前提是List接口的实现类
 */
public class Demo01Collections {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //使用工具类的addAll方法添加多个元素
        Collections.addAll(list,"许嵩","徐良","汪苏泷");
        System.out.println(list);    //[许嵩, 徐良, 汪苏泷]
        //使用工具类的shuffle方法打乱顺序
        Collections.shuffle(list);
        System.out.println(list);    //[徐良, 汪苏泷, 许嵩]
    }
}
```

## sort (List<T> list)方法

案例

实体类Singer(重写Comparable接口中的compareTo方法)

```java
package Advanced.Collection.Collections;

public class Singer implements Comparable<Singer>{
    private String name;
    private int age;

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Singer() {
    }

    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    @Override
    public int compareTo(Singer o) {
        //return 0;
        //自定义比较的规则,比较两个人的年龄(this和参数o)
        return this.getAge()-o.getAge();  //升序
    }
}
```

测试类

```java
package Advanced.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;

/*
     Collections 集合工具类中的sort方法
      - public static <T> void sort(List<T> list):将集合中元素按照默认规则(升序)排序
     使用的前提,被排序的集合里边存储的元素必须实现Comparable接口
     重写接口中的方法compareTo,定义排序的规则
    @Override
    public int compareTo(Singer o) {
        //return 0;
        //自定义比较的规则,比较两个人的年龄(this和参数o)
        return this.getAge()-o.getAge();  //升序
    }
     Comparable接口的排序规则:
       自己(this)-参数:升序
       参数-自己(this):降序
 */
public class Demo02Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,3,1);
        System.out.println(list);  //[5, 3, 1]
        //使用sort方法排序
        Collections.sort(list);
        System.out.println(list);  //[1, 3, 5]

        /*
            排序自定义类型时,比如按照Singer类的age年龄排序
         */
        ArrayList<Singer> singers = new ArrayList<>();
        singers.add(new Singer("许嵩",34));
        singers.add(new Singer("汪苏泷",31));
        singers.add(new Singer("徐良",33));
        Collections.sort(singers);   //按照年龄age排序
        System.out.println(singers); 
    }
}
```

## sort (List<T>list，Comparator<? super T> ) 方法

```java
package Advanced.Collection.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
    Collections 集合工具类中的sort(List<T> list,Comparator<? super T>)方法
       - public static <T> void sort(List<T> list,Comparator<? super T>),将集合按照指定规则排序
    Comparator和Comparable的区别
       Comparable:自己(this)和别人(参数)比较,自己需要实现Comparable接口,重写比较的规则compareTo方法
       Comparator:相当于找一个第三方的裁判,来比较两个
    Comparator的排序规则:
       o1-o2:升序
 */
public class Demo03Sort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(list); //[2, 1, 3]
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2; //升序
            }
        });
        System.out.println(list);

        //当集合的泛型为Singer时候
        ArrayList<Singer> singers = new ArrayList<>();
        singers.add(new Singer("许嵩",34));
        singers.add(new Singer("汪苏泷",31));
        singers.add(new Singer("徐良",33));
        Collections.sort(singers, new Comparator<Singer>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getAge()- o2.getAge(); //按年龄的升序,排序
            }
        });
        System.out.println(singers);
    }
}
```

