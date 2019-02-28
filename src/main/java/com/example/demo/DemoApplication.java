package com.example.demo;

import com.example.demo.algorithm.Distribution;
import com.example.demo.factory.abstr.MilkFactory;
import com.example.demo.factory.func.Factoty;
import com.example.demo.factory.func.TelunsuFactory;
import com.example.demo.factory.func.YiliFactory;
import com.example.demo.factory.simple.SimpleFactory;
import com.example.demo.proxy.Meipo;
import com.example.demo.proxy.Person;
import com.example.demo.proxy.Son;
import com.example.demo.proxy.Zhongji;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

//		System.out.println(new TeLunSu().getName());
        //////////////===工厂
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getMilk("特仑苏"));
        System.out.println(simpleFactory.getMilk("伊利"));
        System.out.println("////////////////// 简单工厂- end");

        Factoty factoty = new TelunsuFactory();
        System.out.println(factoty.getMilk());
        Factoty factoty1 = new YiliFactory();
        System.out.println(factoty1.getMilk());

        System.out.println("////////////////// 方法工厂-end");

        MilkFactory milkFactory = new MilkFactory();
        System.out.println(milkFactory.getTelunsu());
        System.out.println(milkFactory.getYili());
        System.out.println(milkFactory.getSalu());
        System.out.println("////////////////// 抽象工厂-end");

        /////////////////===动态代理

        Person person = (Person) new Meipo().getInstance(new Son());
        person.findLove();
        person.job();
        System.out.println("===========");
        Person person1 = (Person) new Zhongji().getInstance(new Son());

        person1.job();
        person1.findLove();
        System.out.println("========================--end");

        System.out.println("========================权重分配");
        Map<String, String> users1 = new HashMap<>();
        users1.put("a", "10");
        users1.put("b", "10");
        users1.put("c", "20");
        users1.put("d", "10");
        users1.put("e", "50");
        List<String> tasks1 = new ArrayList<String>();
        tasks1.add("1");
        tasks1.add("2");
        tasks1.add("3");
        tasks1.add("4");
        tasks1.add("5");
        tasks1.add("6");
        tasks1.add("7");
        tasks1.add("8");
        tasks1.add("9");
        tasks1.add("10");
        tasks1.add("11");
        tasks1.add("12");
        tasks1.add("13");
        tasks1.add("14");
        tasks1.add("15");
        tasks1.add("16");
        tasks1.add("17");
        tasks1.add("18");
        tasks1.add("19");
        Map<String, List<String>> stringListMap1 = Distribution.allotOfProportion(users1, tasks1);

        stringListMap1.forEach((v, k) -> {
            System.out.println(v + "====" + k);
        });


        System.out.println("========================平均分配");
        List<String> users = new ArrayList<String>();
        users.add("a");
        users.add("b");
        users.add("c");
        users.add("d");
        users.add("e");
        List<String> tasks = new ArrayList<String>();
        tasks.add("1");
        tasks.add("2");
        tasks.add("3");
        tasks.add("4");
        tasks.add("5");
        tasks.add("6");
        tasks.add("7");
        tasks.add("8");
        tasks.add("9");
        tasks.add("10");
        tasks.add("11");
        tasks.add("12");
        tasks.add("13");
        tasks.add("14");
        tasks.add("15");
        tasks.add("16");
        tasks.add("17");
        tasks.add("18");
        tasks.add("19");

        Map<String, List<String>> stringListMap = Distribution.allotOfAverage(users, tasks);
        stringListMap.get(1);
        stringListMap.forEach((k, v) -> {
            System.out.println(k + "==========" + v);
        });


        System.out.println("========================全都分配");
        List<String> users2 = new ArrayList<>();
        users2.add("1");
        users2.add("2");
        users2.add("3");
        List<String> tasks2 = new ArrayList<>();
        tasks2.add("a");
        tasks2.add("b");
        tasks2.add("c");
        Map<String, List<String>> map = Distribution.allotOfAll(users2, tasks2);

        map.forEach((v, k) -> {
            System.out.println(v + "====" + k);
        });

    }

}

