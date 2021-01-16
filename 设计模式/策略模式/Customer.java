package com.hs_vae.DesignPattern.StrategyPattern;

import java.util.Scanner;

//客户类
public class Customer {
    public static void main(String[] args) {
        Context customer = new Context();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入节日:");
        customer.saleManShow(new FestivalInfo(sc.next()));
    }
}
