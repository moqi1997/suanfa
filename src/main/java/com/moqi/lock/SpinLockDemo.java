package com.moqi.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author moqi
 * @date 2020/5/5 14:55
 */
public class SpinLockDemo {
     AtomicReference<Thread> atomicReference = new AtomicReference<>();
     public void myLock() {
         Thread thread = Thread.currentThread();
         System.out.println(Thread.currentThread().getName() + "\t come in");

     }
}
