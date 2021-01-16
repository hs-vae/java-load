package com.hs_vae.DesignPattern.StrategyPattern;
//为中秋节准备的促销活动B
public class StrategyB implements Strategy{
    @Override
    public void show() {
        System.out.println("满200元减50");
    }
}
