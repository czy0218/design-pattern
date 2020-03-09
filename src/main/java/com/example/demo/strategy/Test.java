package com.example.demo.strategy;

/**
 * Created by czy0218 on 2020/3/8.
 * 策略
 */
public class Test {
    public static void main(String[] args) {
        Order order=new Order("1","1111111112324",22.33);
        System.out.println(order.pay(PayType.ALI_PAY));
    }
}
