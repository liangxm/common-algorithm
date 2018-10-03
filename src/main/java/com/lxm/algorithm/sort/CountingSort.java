package com.lxm.algorithm.sort;

/**
 * 计数排序算法
 * <h1>算法描述</h1>
 * <pre>
 *  1. 找出待排序的数组中最大和最小的元素；
 *  2. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 *  3. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 *  4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class CountingSort extends AbstractSort {
    /**
     * 计数排序
     * @param arr 待排序数组
     * @param maxNum 数组中最大值
     */
    private static void countSort(int[] arr, int maxNum) {
        // 创建数组c, 并初始化
        int[] b = new int[arr.length];
        int[] c = new int[maxNum +1];
        for(int i = 0; i < c.length; i++) {
            c[i] = 0;
        }
        // 统计数组arr中每个元素出现的次数
        for(int v:arr) {
            c[v] ++;
        }
        /**
         * 统计数组arr中小于等于某一个数的数的个数
         * 因为小于等于0的数的个数就是等于0的数的个数， 所以迭代从1开始
         */
        for(int i = 1; i < c.length; i++) {
            c[i] = c[i] + c[i - 1];
        }
        for(int v:arr) {
            /**
             * 小于等于arr[i]的数的个数为x就应该将该数放在数组b的第x-1个位置
             * 因为数组的下标从0开始
             */
            b[c[v] - 1] = v;

            /**
             * 下一个arr[i]排在这个arr[i]的前面
             * 下一个arr[i]排在前面的原因是前面为所有小于等于arr[i]的数留足了空间
             */
            c[v]--;
        }
        System.arraycopy(b, 0, arr, 0, b.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23,34,45,56,567,23,54,4,34,56,2,54,6};
        countSort(arr, 567);
        printArr(arr);
    }
}
