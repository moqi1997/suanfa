package com.moqi.sort;

import java.util.Arrays;

/**
 * @author moqi
 * @date 2020/3/18 9:41
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int pivot = arr[(left + right) / 2];
        //while循环的目的是比pivot小的放左大的放右边
        while (l < r) {
            //在pivot的左边的一直找，找到大于pivot的值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的左右的一直找，找到大于pivot的值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //交换完后arr[l] == pivot 让r -= 1
            if (arr[l] == pivot) {
                r -= 1;
            }
            //交换完后arr[r] == pivot 让r += 1
            if (arr[r] == pivot) {
                l += 1;
            }
            if (l == r) {
                l += 1;
                r -= 1;
            }
            //向左递归
            if (left < r) {
                quickSort(arr, left, r);
            }
            //向右递归
            if (right > l) {
                quickSort(arr, l, right);
            }
        }

    }
}
