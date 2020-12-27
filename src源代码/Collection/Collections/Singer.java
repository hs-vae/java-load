package com.hs_vae.Collection.Collections;

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
