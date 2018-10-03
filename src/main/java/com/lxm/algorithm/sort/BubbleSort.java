package com.lxm.algorithm.sort;

/**
 * 冒泡排序算法
 * <h1>算法描述</h1>
 * <pre>
 * 1. 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 3. 针对所有的元素重复以上的步骤，除了最后一个；
 * 4. 重复步骤1~3，直到排序完成。
 * </pre>
 * @author liang
 * @since 2018-10-1 11:27:22
 */
public class BubbleSort extends AbstractSort {
    private static int[] bubbleSort(int[] arr) {
        int len = arr.length;
        for(int i = 0; i < len - 1; i++) {
            for(int j = 0; j < len - 1 - i; j ++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 1, 8, 8, 3, 6, 2, 0, 2, 4, 5, 7, 23, 455, 56, 34, 23, 6, 8, 34, 5};
        arr = bubbleSort(arr);
        printArr(arr);
    }
}
