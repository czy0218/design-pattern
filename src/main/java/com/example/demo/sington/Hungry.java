package com.example.demo.sington;

/**
 * Created by czy0218 on 2019/2/2.
 *
 * 饿汉-线程安全
 *
 * 缺点-类加载时就加载-浪费内存
 */
public class Hungry {
    private Hungry() {
    }

    private static final Hungry HUNGRY = new Hungry();

    public static Hungry getHungry() {
        return HUNGRY;
    }
}
