package com.lxm.algorithm.sort;

/**
 * 希尔排序算法
 * <h1>算法描述</h1>
 * <pre>
 * 1. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
 * 2. 按增量序列个数k，对序列进行k 趟排序；
 * 3. 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，
 *    分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，
 *    表长度即为整个序列的长度。
 * </pre>
 * @author liang
 * @since 2018-10-1 11:27:22
 */
public class ShellSort extends AbstractSort {
    private static int[] shellSort(int[] arr) {
        int len = arr.length, i, j, k, gap;
        // 第一个循环决定比较的间隔
        for(gap = len / 2; gap > 0; gap /= 2) {
            // 第二个循环根据间隔， 将整个数组分成若干子数组
            for(i = 0; i < gap; i++) {
                // 下面两个循环就是子数组内部的插入排序算法
                for(j = i + gap; j < len; j += gap) {
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if(arr[j] < arr[j-gap]) {
                        int temp = arr[j];
                        for(k = j - gap; k >= 0 && arr[k] > temp; k -= gap){
                            arr[k + gap] = arr[k];
                        }
                        arr[k + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8, 3, 3, 23, 34, 23, 12, 34, 56, 43, 23, 345, 546, 2343, 344, 45};
        shellSort(arr);
        printArr(arr);
    }
 }
