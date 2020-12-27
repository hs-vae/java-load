package com.hs_vae.Collection.Set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class Demo04LinkedHashSet {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("许嵩");
        set.add("徐良");
        set.add("徐良");
        set.add("汪苏泷");
        System.out.println(set); //[徐良, 许嵩, 汪苏泷],这是无序的
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("许嵩");
        linked.add("许嵩");
        linked.add("徐良");
        linked.add("汪苏泷");
        System.out.println(linked); //[许嵩, 徐良, 汪苏泷],这是无序的
    }
}
