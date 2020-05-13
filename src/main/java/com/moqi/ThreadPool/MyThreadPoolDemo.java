package com.moqi.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @author moqi
 * @date 2020/5/13 16:19
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "\t办理业务");
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
