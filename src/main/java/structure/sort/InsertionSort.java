package structure.sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 6, 7, 3, 5, 6, 8, 9, 0};
        System.out.println("before nums = " + Arrays.toString(nums));
        insertionSort(nums);
        System.out.println("before nums = " + Arrays.toString(nums));
    }

    /**
     * 插入排序
     * 参考：https://www.jianshu.com/p/07b911fb740e
     * step1. i 指标从 0 开始，依序 "从右方元素" 向 "左方元素" 比对
     * step2. j 从 i 指标开始比对，仅比对 "左方元素" 做排序
     * step3. 左方元素排序时，比对大小若不需要排序则中断 ---> 实现 "左方元素" 已排列大小
     * step4. 依序让右方元素插入左方，直到右方元素完结
     */
    public static void insertionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int currentItem = a[i + 1];
            for (int j = i; j >= 0; j--) {
                if (currentItem < a[j]) {
                    a[j + 1] = a[j];
                    a[j] = currentItem;
                } else {
                    a[j + 1] = currentItem;
                    break;
                }
            }
        }
    }
}
