package com.example.demo.bingfa;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: czy
 * @Date: 2019/4/12 14:45
 * @Version 1.0
 *
 * 1.用于2个线程交换数据
 * 2.校对工作
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        //交换器，交换String类型
        Exchanger<String> ec = new Exchanger<String>();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //张三团伙
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String returnStr = ec.exchange("小乔");
                    System.out.println("绑架者用小乔交换回：" + returnStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //大乔
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String returnStr = ec.exchange("1000万");
                    System.out.println("大乔用1000万交换回：" + returnStr);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();
    }

}
