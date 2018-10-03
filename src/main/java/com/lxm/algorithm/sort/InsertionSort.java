package com.lxm.algorithm.sort;

/**
 * 插入排序算法
 * <h1>算法描述</h1>
 * <pre>
 *  1. 从第一个元素开始，该元素可以认为已经被排序；
 *  2. 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 *  3. 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 *  4. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 *  5. 将新元素插入到该位置后；
 *  6. 重复步骤2~5。
 * </pre>
 * @author liang
 * @since 2018-10-1 11:27:22
 */
public class InsertionSort extends AbstractSort {
    private static int[] insertionSort(int[] arr) {
        int len = arr.length;
        int preIndex, current;
        for(int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = arr[i];
            while(preIndex >= 0 && arr[preIndex] > current) {
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {2,4,67,8,9,2,4,7,4,7,98,3,54,3,2,6,78,0,6,3,4,2,33,245,56,7,65,67,87,433,23,676,865};
        insertionSort(arr);
        printArr(arr);
    }
}
