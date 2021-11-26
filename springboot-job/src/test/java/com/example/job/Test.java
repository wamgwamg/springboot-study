package com.example.job;

import cn.hutool.crypto.SecureUtil;
import com.example.job.entity.Person;
import com.example.job.entity.User;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : wangye
 * @date: 2020-12-10
 * @description:
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("140101199502187324"));
//        System.out.println(SecureUtil.m("140101199502187324"));

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("hepengju", 28, 20000.0));
        personList.add(new Person("lisi"    , 44, 40000.0));
        personList.add(new Person("wangwu"  , 55, 50000.0));
        personList.add(new Person("zhaoliu" , 66, 60000.0));
        personList.add(new Person("zhangsan", 33, 33333.0));
        personList.add(new Person("wgr", 23, 10000.0));


        Map<String, Person> collect = personList.stream().collect(Collectors.toMap(Person::getUserName, Function.identity()));

        Map<String, Person> collect1 = personList.stream().collect(Collectors.toMap(Person::getUserName, Function.identity(), (e1, e2) -> e2));
        Map<String, Person> collect2 = personList.stream().collect(Collectors.toMap(Person::getUserName, Function.identity(), (e1, e2) -> e1));


        Map<String, Map<Integer, Person>> collect3 = personList.stream().collect(Collectors.toMap(Person::getUserName, person -> {
            Map<Integer, Person> map = new HashMap<>();
            map.put(person.getPhone(), person);
            return map;
        }));


        collect1.forEach(
                (key,value)-> System.out.println(key+"----"+collect.get(key))
        );
        System.out.println("----------------------------");
        collect2.forEach(
                (key,value)-> System.out.println(key+"----"+collect.get(key))
        );

    }


}
