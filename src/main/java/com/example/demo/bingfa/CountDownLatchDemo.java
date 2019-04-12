package com.example.demo.bingfa;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: czy
 * @Date: 2019/4/12 14:47
 * @Version 1.0
 *
 *CountDownLatch 倒计时计数器，有一个任务，他需要等待其他某几个任务执行完毕之后才能执行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);
        //任务1
        new Thread() {
            public void run() {
                try {
                    System.out.println("任务1正在执行任务...");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("任务1执行完毕...");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            public void run() {
                try {
                    System.out.println("任务2正在执行任务...");
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println("任务2执行完毕...");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        //主线程
        System.out.println("等待其他2个任务执行完毕，主线程才开始执行任务" + Thread.currentThread().getName());
        try {
            latch.await();
            System.out.println("其他两个任务执行完毕，主线程执行任务：" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
