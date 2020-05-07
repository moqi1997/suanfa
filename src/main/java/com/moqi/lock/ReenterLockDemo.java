package com.moqi.lock;

import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author moqi
 * @date 2020/5/4 11:38
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.sendSMS();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.sendSMS();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    phone.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"t4").start();
    }
}

class Phone implements Runnable{
    public synchronized void sendSMS () throws Exception{
        System.out.println(Thread.currentThread().getName() + "sendSmS");
        sendEmail();
    }
    public synchronized void sendEmail () throws Exception{
        System.out.println(Thread.currentThread().getName() + "sendEmail");

    }
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked get()");
            set();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t invoked set()");
        }finally {
            lock.unlock();
        }
    }
}