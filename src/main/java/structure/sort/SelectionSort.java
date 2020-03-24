package structure.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        /**
         *选择排序： 待排序
         */
        int[] nums = new int[]{12, 342, 1, 56, 8, 789, 3, 5, 999, 33, 88};
        System.out.println("before nums = " + Arrays.toString(nums));
        selectionSort(nums);
        System.out.println("after nums = " + Arrays.toString(nums));
    }


    public static void selectionSort(int[] toSort) {

        for (int i = 0; i < toSort.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j] > toSort[max]) {
                    max = j;
                }
            }
            if (toSort[i] < toSort[max]) {
                int tmp = toSort[i];
                toSort[i] = toSort[max];
                toSort[max] = tmp;
            }
//            System.out.println();
//            System.out.print("第【" + (i + 1) + "】次排序的结果：");
//            printTosort(toSort);
//            System.out.println();
        }

    }

    private static void printTosort(int[] toSort) {
        for (int i = 0; i < toSort.length; i++) {
            System.out.print(toSort[i] + "   ");
        }
    }
}
