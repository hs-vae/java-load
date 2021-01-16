package com.hs_vae.DesignPattern.StrategyPattern;
//促销节日实体类
public class FestivalInfo {
    private String festival;

    public FestivalInfo() {
    }

    public FestivalInfo(String festival) {
        this.festival = festival;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }
}
