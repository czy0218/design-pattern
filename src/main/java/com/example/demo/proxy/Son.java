package com.example.demo.proxy;

/**
 * Created by czy0218 on 2019/2/3.
 */
public class Son implements Person {
    public void findLove() {
        System.out.println("开始谈恋爱了");
    }

    @Override
    public void job() {
        System.out.println("开始找工作了");
    }
}
