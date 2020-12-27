package com.hs_vae.Reflect;

public class Person {
    public String name;
    private int age;
    private int a;
    protected double sex;
    boolean flag;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a=" + a +
                ", sex=" + sex +
                ", flag=" + flag +
                '}';
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
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

    public double getSex() {
        return sex;
    }

    public void setSex(double sex) {
        this.sex = sex;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Person(String name, int age, double sex, boolean flag) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.flag = flag;
    }

    public Person() {
    }
    public void say(){
        System.out.println("该方法已执行!");
    }
    public void eat(String food){
        System.out.println(food);
    }
}
