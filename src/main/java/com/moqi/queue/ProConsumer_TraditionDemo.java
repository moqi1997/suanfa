package com.moqi.queue;

import jdk.nashorn.internal.ir.CatchNode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moqi
 * @date 2020/5/9 18:24
 */
public class ProConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareDate shareDate = new ShareDate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        shareDate.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"aa").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        shareDate.de();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"bb").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        shareDate.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"cc").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        shareDate.de();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        },"dd").start();

    }
}

class ShareDate {
    //资源类
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void increment() throws Exception {
        lock.lock();
        try {
            //1判断
            if (number != 0) {
                //等待，不能生产
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void de() throws Exception {
        lock.lock();
        try {
            //1判断
            if (number == 0) {
                //等待，不能消费
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
