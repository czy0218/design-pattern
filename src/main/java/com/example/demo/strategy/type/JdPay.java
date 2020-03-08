package com.example.demo.strategy.type;

import com.example.demo.strategy.PayState;
import com.example.demo.strategy.Payment;

/**
 * Created by czy0218 on 2020/3/8.
 */
public class JdPay implements Payment {
    @Override
    public PayState pay(String uid, double amount) {
        System.out.println("京东");
        return new PayState(200,111,"成功");
    }
}
