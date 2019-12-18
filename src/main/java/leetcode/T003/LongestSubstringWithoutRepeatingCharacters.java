package leetcode.T003;

import java.util.HashSet;
import java.util.Set;

/**
 * LongestSubstringWithoutRepeatingCharacters
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 */


public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String inputStr = "abcabcbb";

        lengthOfLongestSubstring_planA(inputStr);
        lengthOfLongestSubstring_planB(inputStr);
        lengthOfLongestSubstring_planC(inputStr);
    }

    //leetcode 官方方法
    public static int lengthOfLongestSubstring_planA(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                System.out.println("区间：i=" + i + ",j=" + j);
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //暴力法优化 (缺点对超长数组效果不张，容易发生 timeout)
    public static int lengthOfLongestSubstring_planB(String s) {
        int ans = 0;
        int slen = s.length();

        //从最大范围开始找
        for (int i = slen; i > 0; i--) {
            int beginPos = 0;
            int endPos = i;
            while (endPos <= slen) {
                if (allUnique(s, beginPos, endPos)) {
                    ans = i;
                    System.out.println("结果=" + ans);
                    return ans;
                }
                beginPos++;
                endPos++;
            }
        }
        return ans;
    }

    //滑移窗口法，时间复杂度低
    public static int lengthOfLongestSubstring_planC(String s) {
        int ans = 0;
        int n = s.length();
        int beginPos = 0, endPos = 0;

        while (beginPos < n && endPos < n) {
            if (allUnique(s, beginPos, endPos)) {
                ans = endPos - beginPos + 1;
                endPos++;
            } else {
                beginPos++;
                endPos++;
            }
        }
        System.out.println("结果=" + ans);
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i <= end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


}
