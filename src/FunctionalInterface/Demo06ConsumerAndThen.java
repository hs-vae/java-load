package com.hs_vae.FunctionalInterface;

import java.util.function.Consumer;

/*
    andThen方法需要两个Consumer接口，可以把两个Consumer接口组合到一起，在对数据进行消费
    例如:
    Consumer<com.hs_vae.String> con1
    Consumer<com.hs_vae.String> con2
    com.hs_vae.String s = "hs-vae";
    连接两个Consumer接口,再进行消费
    con1.andThen(con2).accept(s); 谁先写在前边谁先消费
 */
public class Demo06ConsumerAndThen {
    //定义一个方法,方法的参数传递一个字符串和两个Consumer接口
    public static void show(String s, Consumer<String> con1,Consumer<String> con2){
        //使用andThen方法,把con1和con2两个接口连接到一起,再消费数据(先执行con1再执行con2)
        con1.andThen(con2).accept(s);
    }

    public static void main(String[] args) {
        //调用show方法,传递一个字符串,可以使用两个Lambda表达式
        show("Hello",
                (t)->{
                    //消费方式:把字符串转换为大写输出
                    System.out.println(t.toUpperCase());
                },
                (t)->{
                    //消费方式:把字符串转换为小写输出
                    System.out.println(t.toLowerCase());
                });
    }
}
