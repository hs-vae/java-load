package com.hs_vae.DesignPattern.StrategyPattern;
//为圣诞节准备的促销活动C
public class StrategyC implements Strategy{
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
