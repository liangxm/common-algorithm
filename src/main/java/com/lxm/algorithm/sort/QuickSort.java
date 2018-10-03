package com.lxm.algorithm.sort;

/**
 * 快速排序算法
 * <h1>算法描述</h1>
 * <pre>
 *    1. 从数列中挑出一个元素，称为 “基准”（pivot）；
 *    2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 *    在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 *    3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class QuickSort extends AbstractSort {
    private static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }
    private static void qSort(int[] arr, int low, int high) {
        if(low < high) {
            int pivot = partition(arr, low, high); //将数组分为两部分
            qSort(arr, low, pivot - 1);            //递归排序左子数组
            qSort(arr, pivot + 1, high);           //递归排序右子数组
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];   // 交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];   // 交换比枢轴小的记录到右端
        }
        // 扫描完成， 枢轴到位
        arr[low] = pivot;
        // 返回的是枢轴的位置
        return low;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {56,67,23,34,3,21,1,2,6,546,8,434,12,12,45,435,456,2,1,2,3245,5,4,3535};
        quickSort(arr);
        printArr(arr);
    }
}
