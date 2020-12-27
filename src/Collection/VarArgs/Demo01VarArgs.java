package com.hs_vae.Collection.VarArgs;
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
