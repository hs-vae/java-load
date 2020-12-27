package com.hs_vae.LanQiaoTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo01LambdaTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 23, 4, 4, 22, 34, 45, 11, 33);
        int min = list.stream().mapToInt((x) -> x).summaryStatistics().getMin();
        System.out.println(min);

        HashSet<Integer> set = new HashSet<>(list);

//        HashSet<Integer> set = new HashSet<>();
//        set.addAll(list);

        int sum=0;
        for (Integer integer : set) {
            sum+=integer*2;
        }
        System.out.println(sum);
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);

        List<Integer> collect = list.stream().map(x -> 10 * x).distinct().collect(Collectors.toList());
        System.out.println(collect);
        long count = list.stream().filter(x -> x % 11 == 0).count();
        System.out.println(count);
        list.stream().sorted().forEach(System.out::println);



    }
}
