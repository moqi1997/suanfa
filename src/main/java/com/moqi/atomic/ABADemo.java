package com.moqi.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author moqi
 * @date 2020/5/2 18:56
 */
public class ABADemo {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args) {
        System.out.println("============ABA问题的产生=========");
     new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet(100, 101);
                atomicReference.compareAndSet(101, 100);
            }
        },"t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicReference.compareAndSet(100,2019)+"\t" + atomicReference.get().toString());

            }
        },"t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("============ABA问题的解决=========");
        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "第1次版本号：" + stamp);
                try {
                    TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                atomicStampedReference.compareAndSet(100,101,1,atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "第2次版本号：" + atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "第3次版本号：" + atomicStampedReference.getStamp());
            }
        },"t3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName() + "第1次版本号：" + stamp);
                try {
                    TimeUnit.SECONDS.sleep(3);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                boolean result = atomicStampedReference.compareAndSet(100,2019,3,atomicStampedReference.getStamp() + 1);
                System.out.println(Thread.currentThread().getName() + "修改成功否：" + result + "当前实际版本号" + atomicStampedReference.getStamp());
                Integer integer = atomicStampedReference.getReference();
                System.out.println("当前是最新值：" + integer);
            }
        },"t4").start();
    }

}
