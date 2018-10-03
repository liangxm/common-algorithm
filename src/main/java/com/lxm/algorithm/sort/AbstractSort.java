package com.lxm.algorithm.sort;

/**
 * 算法抽象类（提供公共方法）
 * @author liang
 * @since 2018-10-3 09:31:06
 */
class AbstractSort {
    /**
     * 交换元素的位置
     */
    static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
    static void printArr(int[] arr) {
        for(int v:arr) {
            System.out.printf(v + " ");
        }
        System.out.println();
    }
}
