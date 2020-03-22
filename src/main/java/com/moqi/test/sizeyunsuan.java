package com.moqi.test;

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.util.Scanner;

/**
 * @author moqi
 * @date 2020/3/22 12:50
 */
public class sizeyunsuan {
    public static void main(String[] args) {
        System.out.println("请输入四则运算式：");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int symbol = index1(string);
        if (symbol == 0) {
            System.out.println("不是正确的四则运算式子！");
        }
        //找出运算符的前缀和后缀
        String prefix = string.substring(0, symbol);
        String suffix = string.substring(symbol + 1, string.length());
        double a = Double.valueOf(prefix);
        double b = Double.valueOf(suffix);
        //获取运算符
        char c = string.charAt(symbol);
        sizeyunsuan(a,b,c);
    }

    public static void sizeyunsuan(double a, double b, char c) {
        try {
            if (c == '+') {
                System.out.println(a + "+" + b + "=" + (a + b));
            } else if (c == '-') {
                System.out.println(a + "-" + b + "=" + (a - b));
            } else if (c == '*') {
                System.out.println(a + "*" + b + "=" + (a * b));
            } else {
                System.out.println(a + "/" + b + "=" + (a / b));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("不是正确的四则运算式子！");
        }
    }

    public static int index1(String symbol) {
        for (int i = 0; i < symbol.length() - 1; i++) {
            if (symbol.charAt(i) == '+') {
                return i;
            }else if (symbol.charAt(i) == '-') {
                return i;
            }else if (symbol.charAt(i) == '*') {
                return i;
            }else if (symbol.charAt(i) == '/') {
                return i;
            }
        }
        return 0;
    }
}
