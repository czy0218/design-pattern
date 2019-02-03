package com.example.demo;

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

    }

}

