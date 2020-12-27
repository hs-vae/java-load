package com.hs_vae.Collection.Collections;

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
        Collections.sort(singers);
        System.out.println(singers);
    }
}
