package structure.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 7, 3, 5, 6, 8, 9, 0};
        System.out.println("before nums = " + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("before nums = " + Arrays.toString(nums));
    }

    /***
     * 冒泡排序
     * 参考：https://www.jianshu.com/p/f31de0e89f7e
     * step1. i 指标从 "最末端" 开始，内圈 j 持续比对，每一遍历都能得出最大值排在 "对尾"
     * step2. j 指标持续交换，直到 i 指标至首端
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; --i) { // 每次需要排序的长度
            for (int j = 0; j < i; ++j) { // 从第一个元素到第i个元素
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }




}
