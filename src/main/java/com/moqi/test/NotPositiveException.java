package com.moqi.test;

import java.util.Scanner;

/**
 * @author moqi
 * @date 2020/3/26 12:12
 * （9-3）对输入的字符串进行判断。要求如下：
 *
 * （1） 自定义一个异常类NotPositiveException，继承Exception，
 *
 *  (2) 输入一个字符串str，利用Integer的parseInt(str)方法把字符串str解析成整数x；
 *
 *   3)如果x是负整数或零，抛出NotPositiveException对象；
 *
 *  (4)如果不能解析成功，捕获parseInt(str)方法抛出的NumberFormatException异常
 *
 * （5）如果有其它异常也能使程序正常结束不被中断（提示：需要捕获Exception异常）。
 *
 * 运行结果如下图所示。
 */
//（1） 自定义一个异常类NotPositiveException，继承Exception，
public class NotPositiveException extends Exception{
    NotPositiveException(String messge) {
        super(messge
        );
    }
}
class NotPositiveExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        try {
            Integer integer = parseInt(str);
            //3)如果x是负整数或零，抛出NotPositiveException对象；
            if (integer < 0) {
                throw new NotPositiveException("如果x是负整数或零，抛出NotPositiveException对象");
            }
        } catch (NotPositiveException e) {
            System.out.println( e.getMessage());
        }
    }
//4)如果不能解析成功，捕获parseInt(str)方法抛出的NumberFormatException异常
    private static Integer parseInt(String str) throws NumberFormatException{
        //(2) 输入一个字符串str，利用Integer的parseInt(str)方法把字符串str解析成整数x；
        return Integer.parseInt(str);
    }
}
