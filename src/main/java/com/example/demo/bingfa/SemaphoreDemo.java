package com.example.demo.bingfa;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: czy
 * @Date: 2019/4/12 14:00
 * @Version 1.0
 *
 * Semaphore信号量（控制并发线程数）：
 * 应用场景：1.限流；2.资源访问需要控制（数据库连接，打印机的接口）
 */
public class SemaphoreDemo {
    class SemaphoreRunnable implements Runnable {
        private Semaphore semaphore;
        private int user; //记录第几个用户

        public SemaphoreRunnable(Semaphore semaphore, int user) {
            this.semaphore = semaphore;
            this.user = user;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("用户" + user + "进入窗口，准备买票");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("用户" + user + "买票完成，即将离开");
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("用户" + user + "离开窗口");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void execute() {
        final Semaphore semaphore = new Semaphore(2);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new SemaphoreRunnable(semaphore, (i + 1)));
        }
        threadPool.shutdown();
    }

    public static void main(String[] args) {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo();
        semaphoreDemo.execute();
    }
}
