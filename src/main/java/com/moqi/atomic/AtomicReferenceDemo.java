package com.moqi.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author moqi
 * @date 2020/5/2 18:32
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("z3",22);
        User li4 = new User("li4",23);
        AtomicReference<User> objectAtomicReference = new AtomicReference<>();
        objectAtomicReference.set(z3);
        System.out.println(objectAtomicReference.compareAndSet(z3,li4)+"\t" + objectAtomicReference.get().toString());
        System.out.println(objectAtomicReference.compareAndSet(z3,li4)+"\t" + objectAtomicReference.get().toString());
    }
}
class User {
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
