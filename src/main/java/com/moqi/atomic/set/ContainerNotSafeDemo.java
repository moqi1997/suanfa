package com.moqi.atomic.set;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author moqi
 * @date 2020/5/3 9:55
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i < 30; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list);
                }
            },String.valueOf(i)).start();
        }
        //
        /*
        * 故障现象java.util.ConcurrentModificationException
        * 解决方法1
        * new Vector<>()
        * 解决方法2
        * Collections.synchronizedList(new ArrayList<>());
        * 解决方法3
        * new coyonwrite
        * */
    }
}
