package structure.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 7, 9, 5, 8};
        System.out.println("before nums = " + Arrays.toString(nums));
        mergeSort(nums, nums.length);
        System.out.println("after nums = " + Arrays.toString(nums));
    }

    /**
     * 归并排序
     *
     * @param a 待排序的数组
     * @param n 数组大小
     */
    public static void mergeSort(int[] a, int n) {
        sort(a, 0, n - 1);
    }

    static void sort(int[] A, int lo, int hi) {
        // 判断是否只剩下最后一个元素
        if (lo >= hi) return;

        // 从中间将数组分成两个部分
        int mid = lo + (hi - lo) / 2;

        // 分别递归地将左右两半排好序
        sort(A, lo, mid);
        sort(A, mid + 1, hi);

        // 将排好序的左右两半合并
        merge(A, lo, mid, hi);
    }

    static int  count = 0;

    static void merge(int[] nums, int lo, int mid, int hi) {
        System.out.println("------- 第"+(++count)+"次 merge -------");
        System.out.println("=== row ===, nums= " + Arrays.toString(nums) + ", lo=" + lo + ", mid=" + mid + ", hi=" + hi);
        // 复制一份原来的数组
        int[] copy = nums.clone();

        // 定义一个 k 指针表示从什么位置开始修改原来的数组，i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = lo, i = lo, j = mid + 1;
        System.out.println("=== index ===, k=" + k + ", i=" + i + ", j=" + j);

        while (k <= hi) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j > hi) {
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else {
                nums[k++] = copy[i++];
            }
        }
    }
}
