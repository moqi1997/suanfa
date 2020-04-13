package com.moqi.test;

/**
 * @author moqi
 * @date 2020/4/13 17:30
 */
public class test1 {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf("127")==Integer.valueOf("127"));
        System.out.println(Integer.valueOf("128")==Integer.valueOf("128"));
        System.out.println(Integer.parseInt("128")==Integer.valueOf("128"));
    }
}
