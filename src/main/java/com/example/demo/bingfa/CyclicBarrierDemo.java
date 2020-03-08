package com.example.demo.bingfa;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: czy
 * @Date: 2019/4/12 14:42
 * @Version 1.0
 *
 * CyclicBarrier(可循环的障碍物)
 * 场景：在多线程计算数据之后，最后需要合并结果。
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        //3个人聚餐
        final CyclicBarrier cb = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("人员全部到齐，开始拍照。。。。");
            }
        });
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //模拟三个用户
        for (int i = 0; i < 3; i++) {
            final int user = i + 1;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "号到达聚餐点，当前已有" + (cb.getNumberWaiting() + 1) + "人到达");
                        //阻塞
                        cb.await();
                        if (user == 1) System.out.println("拍完照后，开始吃饭。。。");
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println(user + "吃完饭，准备回家。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPool.execute(r);
        }
        threadPool.shutdown();
    }
}
