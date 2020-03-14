package com.moqi.sort;

import java.util.Arrays;

/**
 * @author moqi
 * @date 2020/3/14 16:11
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        //shellSort(arr);
        shellSort1(arr);
    }
    //逐步推导
    public static void shellSort(int[] arr) {
        int temp = 0;
        //希尔排序1
        //第一轮排序试讲10数据分成5组
        for (int i = 0;i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素）步长5
            for (int j = i - 5; j >= 0 ; j -= 5) {
                //如果当前元素大于步长后的元素交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }
        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));
        //希尔排序2
        //第二轮排序试讲10数据分成5组
        for (int i = 0;i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素）步长5
            for (int j = i - 2; j >= 0 ; j -= 2) {
                //如果当前元素大于步长后的元素交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        System.out.println("希尔排序2轮后=" + Arrays.toString(arr));
        //希尔排序3
        //第三轮排序试讲10数据分成5组
        for (int i = 0;i < arr.length; i++) {
            //遍历各组中所有的元素（共5组，每组2个元素）步长5
            for (int j = i - 1; j >= 0 ; j -= 1) {
                //如果当前元素大于步长后的元素交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j +1] = temp;
                }
            }
        }
        System.out.println("希尔排序3轮后=" + Arrays.toString(arr));
    }
    public static void shellSort1(int[] arr) {
        int temp = 0;
        //希尔排序1
        //第一轮排序试讲10数据分成5组
        for (int gap = arr.length / 2; gap > 0 ; gap /= 2) {
            for (int i = 0;i < arr.length; i++) {
                //遍历各组中所有的元素（共5组，每组2个元素）步长5
                for (int j = i - gap; j >= 0 ; j -= gap) {
                    //如果当前元素大于步长后的元素交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println("优化后的希尔排序轮后=" + Arrays.toString(arr));
    }
}
