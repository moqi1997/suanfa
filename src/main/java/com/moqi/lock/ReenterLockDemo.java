package com.moqi.lock;

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
    }
}

class Phone{
    public synchronized void sendSMS () throws Exception{
        System.out.println(Thread.currentThread().getName() + "sendSmS");
        sendEmail();
    }
    public synchronized void sendEmail () throws Exception{
        System.out.println(Thread.currentThread().getName() + "sendEmail");

    }
        }