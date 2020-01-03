package leetcode;

public class T026 {

    /**
     * 26. 删除排序数组中的重复项
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     */


    public static void main(String[] args) {

        int[] nums = {0, 0, 0, 0, 0, 1, 1, 1, 5, 6};
        removeDuplicates(nums);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        print(nums);
        return i + 1;
    }

    private static void print(int[] nums) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println("");

    }


}
