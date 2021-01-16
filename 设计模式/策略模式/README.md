# 概述

给出一个例子，比如我们去旅游出行模式有很多种，可以骑自行车、坐汽车、坐火车、坐飞机。

![image-20210116214311127](https://picture.hs-vae.com/image-20210116214311127.png)

再给出一个例子，作为程序员开发时候需要选择一款IDE，开发的工具有很多，可以选择idea，可以选择eclipse，也可以使用其他的一些开发工具

![image-20210116214330646](https://picture.hs-vae.com/image-20210116214330646.png)

定义

该模式定义了一系列算法，并将每个算法封装起来，使它们可以相互替换，并且算法的变化不会影响使用算法的客户。策略模式属于对象行为模式，它通过对算法进行封装，把使用算法的责任(即出现时选择哪种交通工具)和算法的实现(选择的交通工具是怎样到达目的地)分割开来，并委派给不同的对象对这些算法进行管理。

# 结构

策略模式的主要角色如下：

* 抽象策略 (Strategy) 类：这是一个抽象角色，通常由一个接口或抽象类实现，此角色给出所有的具体策略类所需的接口
* 具体策略 (Concrete Strategy) 类：实现了抽象策略定义的接口，提供具体的算法实现或行为。
* 环境 (Context) 类：持有一个策略类的引用，最终给客户端调用

# 案例实现

一家商场在年度的促销活动，针对不同的节日(春节、中秋节、圣诞节) 推出不同的促销活动，通过客户输入的节日名称，获得该节日对应的促销活动并展示给客户，类图如下：

![image-20210116215636581](https://picture.hs-vae.com/image-20210116215636581.png)

代码如下：

**定义一个Strategy接口(即商场所有促销活动的共同接口)**

```java
package com.hs_vae.DesignPattern.StrategyPattern;

public interface Strategy {
    void show();
}
```

**定义具体的策略角色(Concrete Strategy) ：每个节日具体的促销活动**

策略A

```java
package com.hs_vae.DesignPattern.StrategyPattern;
//为春节准备的促销活动A
public class StrategyA implements Strategy{
    @Override
    public void show() {
        System.out.println("全场8折!");
    }
}
```

策略B

```java
package com.hs_vae.DesignPattern.StrategyPattern;
//为中秋节准备的促销活动B
public class StrategyB implements Strategy{
    @Override
    public void show() {
        System.out.println("满200元减50");
    }
}
```

策略C

```java
package com.hs_vae.DesignPattern.StrategyPattern;
//为圣诞节准备的促销活动C
public class StrategyC implements Strategy{
    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
```

**定义一个促销节日实体类(FestivalInfo)**

```java
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
```

**定义环境类(Context)，这里相当于销售员**

```java
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
```

**定义客户类(Customer)即测试类**

```java
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
```

测试结果截图

![image-20210116225930460](https://picture.hs-vae.com/image-20210116225930460.png)

![image-20210116225531755](https://picture.hs-vae.com/image-20210116225531755.png)

![image-20210116225948431](https://picture.hs-vae.com/image-20210116225948431.png)

![image-20210116231110421](https://picture.hs-vae.com/image-20210116231110421.png)

通过输入节日名称，就可以将该节日对应的促销活动展示出来，通过策略模式我们将选择什么节日与对应的节日促销活动具体是怎样分隔开来，因为它们都是完成相同的工作那就是开展促销活动，只是实现方式不同，有的是8折有的是买一送一，这样做的好处就是减少了很多相同的代码，减少了不同的节日促销活动之间的耦合

# 优缺点

优点

* 策略类之间可以自由切换

  由于策略类都实现同一个接口，所以使它们之间可以自由切换。

* 易于扩展

  增加一个新的策略只需要添加一个具体的策略类即可，基本不需要改变原有的代码，符合“开闭原则“

* 避免使用多重条件选择语句（if else），充分体现面向对象设计思想。

缺点

* 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
* 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量。

# 使用场景

* 一个系统需要动态地在几种算法中选择一种时，可将每个算法封装到策略类中。
* 一个类定义了多种行为，并且这些行为在这个类的操作中以多个条件语句的形式出现，可将每个条件分支移入它们各自的策略类中以代替这些条件语句。
* 系统中各算法彼此完全独立，且要求对客户隐藏具体算法的实现细节时。
* 系统要求使用算法的客户不应该知道其操作的数据时，可使用策略模式来隐藏与算法相关的数据结构。
* 多个类只区别在表现行为不同，可以使用策略模式，在运行时动态选择具体要执行的行为。

# JDK源码解析

`Comparator` 中的策略模式。在Arrays类中有一个 `sort()` 方法，如下：

```java
public class Arrays{
    public static <T> void sort(T[] a, Comparator<? super T> c) {
        if (c == null) {
            sort(a);
        } else {
            if (LegacyMergeSort.userRequested)
                legacyMergeSort(a, c);
            else
                TimSort.sort(a, 0, a.length, c, null, 0, 0);
        }
    }
}
```

Arrays就是一个环境角色类，这个sort方法可以传一个新策略让Arrays根据这个策略来进行排序。就比如下面的测试类。

```java
public class demo {
    public static void main(String[] args) {

        Integer[] data = {12, 2, 3, 2, 4, 5, 1};
        // 实现降序排序
        Arrays.sort(data, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(data)); //[12, 5, 4, 3, 2, 2, 1]
    }
}
```

这里我们在调用Arrays的sort方法时，第二个参数传递的是Comparator接口的子实现类对象。所以Comparator充当的是抽象策略角色，而具体的子实现类充当的是具体策略角色。环境角色类（Arrays）应该持有抽象策略的引用来调用。那么，Arrays类的sort方法到底有没有使用Comparator子实现类中的 `compare()` 方法吗？让我们继续查看TimSort类的 `sort()` 方法，代码如下：

```java
class TimSort<T> {
    static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c,
                         T[] work, int workBase, int workLen) {
        assert c != null && a != null && lo >= 0 && lo <= hi && hi <= a.length;

        int nRemaining  = hi - lo;
        if (nRemaining < 2)
            return;  // Arrays of size 0 and 1 are always sorted

        // If array is small, do a "mini-TimSort" with no merges
        if (nRemaining < MIN_MERGE) {
            int initRunLen = countRunAndMakeAscending(a, lo, hi, c);
            binarySort(a, lo, hi, lo + initRunLen, c);
            return;
        }
        ...
    }   
        
    private static <T> int countRunAndMakeAscending(T[] a, int lo, int hi,Comparator<? super T> c) {
        assert lo < hi;
        int runHi = lo + 1;
        if (runHi == hi)
            return 1;

        // Find end of run, and reverse range if descending
        if (c.compare(a[runHi++], a[lo]) < 0) { // Descending
            while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) < 0)
                runHi++;
            reverseRange(a, lo, runHi);
        } else {                              // Ascending
            while (runHi < hi && c.compare(a[runHi], a[runHi - 1]) >= 0)
                runHi++;
        }

        return runHi - lo;
    }
}
```

上面的代码中最终会跑到 `countRunAndMakeAscending()` 这个方法中。我们可以看见，只用了compare方法，所以在调用Arrays.sort方法只传具体compare重写方法的类对象就行，这也是Comparator接口中必须要子类实现的一个方法。

