package com.moqi.tree;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author moqi
 * @date 2020/3/26 9:55
 */
public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};

    }

    //编写的一个堆排序的方法
    public static void heapSort(int arr[]) {
        System.out.println("堆排序！");
    }
    //将一个数组二叉树,调整成一个大根堆

    /**
     * @param arr    待调整的数组
     * @param i      待调整的数组
     * @param lenght 待调整的数组
     */
    public static void adjustHeap(int arr[], int i, int lenght) {
        //先取出当前元素的值，保存在临时变量
        int temp = arr[i];
        //开始调整
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {

        }
    }

}
