package com.hs_vae.Debug;

public class Demo01Debug {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println(sum);
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
        }
        method();
    }

    private static void method() {
        System.out.println("Hello,World!");
        System.out.println("Hello,World!");
        System.out.println("Hello,World!");
    }
}
