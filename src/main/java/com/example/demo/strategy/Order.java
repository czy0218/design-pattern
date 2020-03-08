package com.example.demo.strategy;

/**
 * Created by czy0218 on 2020/3/8.
 */
public class Order {
    private String uid;
    private String orderId;

    private double amount;

    public Order(String uid, String orderId, double amount) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay(PayType payType){
        return payType.get().pay(uid,amount);
    }
}
