package com.hs_vae.DesignPattern.StrategyPattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//环境类(销售员),用来向客户展示促销活动
public class Context {

    private Strategy strategy;  //聚合策略类对象
    private String festival;
    //定义一个泛型为Context的List集合,存储不同节日对应的促销活动和节日名称
    private static List<Context> strategyList = new ArrayList<>();

    //使用静态代码块,将不同的节日与该节日的促销活动对应,即与策略角色A,B,C对应
    static {
        strategyList.add(new Context(new StrategyA(),"春节"));
        strategyList.add(new Context(new StrategyB(),"中秋节"));
        strategyList.add(new Context(new StrategyC(),"圣诞节"));
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public String getFestival() {
        return festival;
    }

    public void setFestival(String festival) {
        this.festival = festival;
    }

    public static List<Context> getStrategyList() {
        return strategyList;
    }

    public static void setStrategyList(List<Context> strategyList) {
        Context.strategyList = strategyList;
    }

    public Context() {
    }

    public Context(Strategy strategy, String festival) {
        this.strategy = strategy;
        this.festival = festival;
    }

    //由促销员展示具体的促销活动给用户
    public void saleManShow(FestivalInfo festivalInfo){
        //遍历策略集合
            for (Context context : strategyList) {
                //判断商场已有的促销节日与客户输入的促销节日是否相同
                if (context.getFestival().equals(festivalInfo.getFestival())){
                    //如果相同那么就会执行该节日对应的策略实现类里的show方法,即展示促销活动
                    System.out.print(context.getFestival()+"的促销活动是:");
                    context.getStrategy().show();
                }else {
                    System.out.println("本商场没有该促销活动节日");
                    break;
                }
            }
    }
}
