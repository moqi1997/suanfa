package com.moqi.kmp;

/**
 * @author moqi
 * @date 2020/3/27 16:27
 * 现在要判断str1是否含有srt2，如果存在《就返回第一次出现的位置，如果没有，就返回-1；
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "123 32445 23455456";
        String str2 ="456";
        int index = violenceMatch(str1,str2);
        System.out.println("index=" + index);
    }

    //暴力匹配算法实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0; //i索引指向s1
        int j = 0; //j索引指向s2
        //保证匹配不越界
        while (i < s1Len && j < s2Len) {
            //匹配ol
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                //没有匹配成功
                i = i - (j - 1);
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }
}
