package com.hs_vae.Lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Demo10SunmaryStatistics {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        /*
            IntStream mapToInt(ToIntFunction<? super T> mapper)
            使用mapToInt方法返回一个IntStream,其中包含将给定函数应用于此流的元素的结果，在使用summaryStatistics方法产生int类型对象
         */
        IntSummaryStatistics stat = list.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("平均数:"+stat.getAverage());
        System.out.println("最大值:"+stat.getMax());
        System.out.println("最小数:"+stat.getMin());
        System.out.println("总和:"+stat.getSum());
    }
}
