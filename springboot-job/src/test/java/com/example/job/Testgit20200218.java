package com.example.job;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

/**
 * @author : wangye
 * @date: 2020-12-10
 * @description:
 */
public class Testgit20200218 {

    public static void main(String[] args) {

        System.out.println((120l & 120l));
        System.out.println((1103 & 1099511627776L) == 1099511627776L);

        List<Long> b = new ArrayList<Long>();
        for (long i = 100000000l;i<1000000000l;i++){
            boolean a = ((i & 1099511627776L) == 1099511627776L);
            if (a){
                b.add(i);
            }
        }


        HashSet<String> s = new HashSet<>();
        s.add("d");
        s.add("r");
        s.add("a");
        s.add("y");

        TreeSet<String> s1 = new TreeSet<>();
        s1.add("r");
        s1.add("a");
        s1.add("y");
        s1.add("d");

        System.out.println(s.toString());
        System.out.println(s1.toString());


       A a = () -> System.out.println("执行3……");
       a.b();

    }

    interface A{
       void b();
    }
}
