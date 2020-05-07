package com.moqi.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author moqi
 * @date 2020/5/7 10:16
 */
public class readandwritelockdemo {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 5; i++) {
            final int tempint = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cache.put(tempint + "",tempint + "");
                }
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int tempint = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    cache.get(tempint + "");
                }
            },String.valueOf(i)).start();
        }
    }
}
class Cache{
    private volatile Map<String,Object> map= new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void put(String key,Object object) {
        lock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + "开始写入-------");
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object result = map.put(key,object);
        System.out.println(Thread.currentThread().getName() + "写入完成-------" + result);
        lock.writeLock().unlock();
    }
    public void get(String key) {
        lock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + "开始读取-------");
        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object result = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取完成-------" + result);
        lock.readLock().unlock();
    }
}