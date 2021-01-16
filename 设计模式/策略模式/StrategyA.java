package com.hs_vae.DesignPattern.StrategyPattern;
//为春节准备的促销活动A
public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("全场8折!");
    }
}
