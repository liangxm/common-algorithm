package com.lxm.algorithm.sort;

/**
 * 归并排序算法
 * <h1>算法描述</h1>
 * <pre>
 * 1、申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2、设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3、比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4、重复步骤3直到某一指针达到序列尾
 * 5、将另一序列剩下的所有元素直接复制到合并序列尾
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class MergeSort extends AbstractSort {
    private static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        // 找出中间索引
        int center = (left + right) / 2;
        // 对左边数组进行递归
        sort(arr, left, center);
        // 对右边数组进行递归
        sort(arr, center + 1, right);
        // 合并
        merge(arr, left, center, right);
    }

    private static void merge(int[] arr, int left, int center, int right) {
        // 临时数组
        int[] tmpArr = new int[arr.length];
        // 右数组第一个元素索引
        int mid = center + 1;
        // third 记录临时数组的索引
        int third = left;
        // 缓存左数组第一个元素的索引
        int tmp = left;
        while (left <= center && mid <= right) {
            // 从两个数组中取出最小的放入临时数组
            if(arr[left] <= arr[mid]) {
                tmpArr[third++] = arr[left++];
            } else {
                tmpArr[third++] = arr[mid++];
            }
        }
        // 剩余部分一次放入临时数组（实际上两个while只会执行其中一个）
        while (mid <= right) {
            tmpArr[third++] = arr[mid++];
        }
        while(left <= center) {
            tmpArr[third++] = arr[left++];
        }
        // 将临时数组中的内容拷贝到原数组中
        // （原left-right范围的内容被复制回原数组）
        while (tmp <= right) {
            arr[tmp] = tmpArr[tmp++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5,34, 56, 23, 345, 56, 21, 675, 67, 12, 435, 56, 73, 3, 23};
        mergeSort(arr);
        printArr(arr);
    }
}
