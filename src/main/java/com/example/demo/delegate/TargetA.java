package com.example.demo.delegate;

/**
 * Created by czy0218 on 2020/3/9.
 */
public class TargetA implements ITarget {
    @Override
    public void doing(String commond) {
        System.out.println("A-" + commond);
    }
}
