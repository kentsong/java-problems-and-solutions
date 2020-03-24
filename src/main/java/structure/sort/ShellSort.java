package structure.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] nums = new int[]{12, 342, 1, 56, 8, 789, 3, 5, 999, 33, 88};
        System.out.println("before nums = " + Arrays.toString(nums));
        ShellSort(nums);
        System.out.println("after nums = " + Arrays.toString(nums));
    }


    /**
     * 希尔排序
     * https://www.jianshu.com/p/0115a6cadc53
     *
     * @param num
     */
    public static void ShellSort(int num[]) {
        int temp;
        //默认步长为数组长度除以2
        int step = num.length;
        while (true) {
            step = step / 2;
            //确定分组数
            for (int i = 0; i < step; i++) {
                //对分组数据进行直接插入排序
                for (int j = i + step; j < num.length; j = j + step) {
                    temp = num[j];
                    int k;
                    for (k = j - step; k >= 0; k = k - step) {
                        if (num[k] > temp) {
                            num[k + step] = num[k];
                        } else {
                            break;
                        }
                    }
                    num[k + step] = temp;
                }
            }
            if (step == 1) {
                break;
            }
        }
    }

}
