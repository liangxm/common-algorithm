package com.lxm.algorithm.sort;

/**
 * 堆排序算法
 * <h1>算法描述</h1>
 * <pre>
 * 1. 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
 * 2. 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),
 *    且满足R[1,2…n-1]<=r[n]；< span=""></=r[n]；<>
 * 3. 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，
 *    然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。
 *    不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。
 * </pre>
 * @author liang
 * @since 2018-10-3 09:31:06
 */
public class HeapSort extends AbstractSort {
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for(int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换， 并且在调整二叉树， 时期成为大顶堆
        for(int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);  //  将堆定记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆， 不符合则调整
        }
    }

    /**
     * 构建堆的过程
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for(father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树， 则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child ++; // 序号增1， 指向右子树
            }

            // 如果父节点小于孩子节点， 则需要交换
            if(father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏， 不需要调整
            }
        }
        arr[i] = father;
    }

    /**
     * 获取到左孩子节点
     */
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {23, 34, 56, 78, 23, 65, 87, 34, 67, 87, 32, 342, 45, 65, 56};
        heapSort(arr);
        printArr(arr);
    }
}
