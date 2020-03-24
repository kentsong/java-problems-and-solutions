package structure.sort;

import java.util.Arrays;
import java.util.Random;

public class SortCompareTimeDemo {
    public static void main(String[] args) {

        int[] nums = genRandomNums(100000);
        System.out.println(nums.length);
        System.out.println("before nums = " + Arrays.toString(nums));

        long start = System.currentTimeMillis();
        BubbleSort.bubbleSort(nums.clone());
        long end = System.currentTimeMillis();
        System.out.println("BubbleSort spent time="+(end - start));

        start = System.currentTimeMillis();
        SelectionSort.selectionSort(nums.clone());
        end = System.currentTimeMillis();
        System.out.println("SelectionSort spent time="+(end - start));

        start = System.currentTimeMillis();
        InsertionSort.insertionSort(nums.clone());
        end = System.currentTimeMillis();
        System.out.println("InsertionSort spent time="+(end - start));

        start = System.currentTimeMillis();
        ShellSort.ShellSort(nums.clone());
        end = System.currentTimeMillis();
        System.out.println("ShellSort spent time="+(end - start));

        start = System.currentTimeMillis();
        MergeSort.mergeSort(nums.clone());
        end = System.currentTimeMillis();
        System.out.println("MargeSort spent time="+(end - start));

        start = System.currentTimeMillis();
        QuickSort.quickSort(nums.clone());
        end = System.currentTimeMillis();
        System.out.println("QuickSort spent time="+(end - start));
    }


    private static int[] genRandomNums(int length) {
        int[] nums = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length - 1; i++) {
            nums[i] = rand.nextInt(1000);
        }
        return nums;
    }

}
