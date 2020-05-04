package com.moqi.atomic.set;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author moqi
 * @date 2020/5/3 9:55
 */
public class ContainerNotSafeDemoSet {
    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    set.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(set);
                }
            },String.valueOf(i)).start();
        }
        //
        /*
        * 故障现象java.util.ConcurrentModificationException
        * 解决方法1
        * Collections.synchronizedSet(new HashSet<>());
        * 解决方法2
        *  new CopyOnWriteArraySet<>();
        * 解决方法3
        * new coyonwrite
        * */
    }
}
