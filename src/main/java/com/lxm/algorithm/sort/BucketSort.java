package com.lxm.algorithm.sort;

import java.io.IOException;

/**
 * 桶排序算法
 * <h1>算法描述</h1>
 * <pre>
 *  1. 设置一个定量的数组当作空桶；
 *  2. 遍历输入数据，并且把数据一个一个放到对应的桶里去；
 *  3. 对每个不是空的桶进行排序；
 *  4. 从不是空的桶里把排好序的数据拼接起来。
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class BucketSort extends AbstractSort {
    private static final int excpetElement = -9999;
    private static void bucketSort(int[] arr, int maxNum) throws IOException{
        int[] sorted = new int[maxNum+1]; // 空桶
        for(int i = 0; i < sorted.length; i++) {
            sorted[i] = excpetElement;
        }

        for(int v:arr) {
            if(v == excpetElement)
                throw new IOException();
            sorted[v] = v; // 把数据放到对应索引的位置
        }

        int tmpIndex = 0;
        for(int v:sorted) {
            if(v!=excpetElement) {
                arr[tmpIndex++] = v;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 34, 45, 23, 54, 56, 23, 87, 23, 56};
        try {
            bucketSort(arr, 87);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printArr(arr);
    }
}
