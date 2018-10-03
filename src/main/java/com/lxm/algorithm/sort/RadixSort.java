package com.lxm.algorithm.sort;

/**
 * 基数排序算法
 * <h1>算法描述</h1>
 * <pre>
 *  1. 取得数组中的最大数，并取得位数；
 *  2. arr为原始数组，从最低位开始取每个位组成radix数组；
 *  3. 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class RadixSort extends AbstractSort {
    private static void radixSort(int[] arr, int maxNum) {
        int n = 1; // 代表位数对应的数
        int k = 0; // 保存每一位排序后的结果用于下一位的排序输入
        int length = arr.length;
        int[][] bucket = new int[10][length]; // 排序桶用于保存每次排序后的结果， 这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[length]; // 用于保存每个桶里有多少个数字
        while(n < maxNum) {
            for(int num:arr) {
                int digit = (num/n) % 10;
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }
            for(int i = 0; i < length; i++) { // 将前一个循环生成的桶里的数据覆盖到原数组中用于保存这一位的排序结果
                if(order[i] != 0) { // 这个桶里有数据， 从上到下遍历这个桶并将数据保存到原数组中
                    for(int j=0; j < order[i]; j++) {
                        arr[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0; // 将桶里计数器置0， 用于下一次位排序
            }
            n *= 10;
            k = 0; // 将k置为0, 用户下一轮保存位排序结果
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {23, 34, 56, 8, 23, 65, 34, 687, 123, 32, 435};
        radixSort(arr, 687);
        printArr(arr);
    }
}
