package com.moqi.lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author moqi
 * @date 2020/5/7 12:23
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("同学" + Thread.currentThread().getName() + "\t上完自习离开教室");
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t$$$$$$$$$$班长关门走人");
    }
}
