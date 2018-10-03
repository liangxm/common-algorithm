package com.lxm.algorithm.sort;

/**
 * 选择排序算法
 * <h1>算法描述</h1>
 * <pre>
 *    1. 初始状态：无序区为R[1..n]，有序区为空；
 *    2. 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。
 *       该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，
 *       使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 *    3. n-1趟结束，数组有序化了。
 * </pre>
 * @author liang
 * @since 2018-10-1 11:27:22
 */
public class SelectionSort extends AbstractSort {
    /** 正序 */
    private static int[] selectionSort1(int[] arr) {
        int len = arr.length;
        int minIndex;
        for(int i = 0; i < len - 1; i++) {
            minIndex = i;
            for(int j = i + 1; j < len; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }
    /** 序 */
    private static int[] selectionSort2(int[] arr) {
        int len = arr.length;
        int maxIndex;
        for(int i = 0; i < len - 1; i++) {
            maxIndex = i;
            for(int j = i+1; j < len; j++) {
                if(arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            swap(arr, maxIndex, i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {4, 54, 565, 67, 34, 6, 34, 76, 23, 8, 3, 8, 4, 34};
        selectionSort1(arr);
        for(int v:arr) {
            System.out.printf(v + " ");
        }
        System.out.println();
    }
}
