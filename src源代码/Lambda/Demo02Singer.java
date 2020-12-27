package com.hs_vae.Lambda;
/*
    Lambda表达式无参无返回值
 */
public class Demo02Singer {
    public static void main(String[] args) {
        sing(new Singer() {
            @Override
            public void writeMusic() {
                System.out.println("大家好我是Vae");
            }
        });
        sing(()-> System.out.println("大家好我是Vae(com.hs_vae.Lambda)"));
    }
    public static void sing(Singer singer){
        singer.writeMusic();
    }
}
